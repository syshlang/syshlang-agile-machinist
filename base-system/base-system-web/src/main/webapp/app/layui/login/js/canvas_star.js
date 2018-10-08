/*
 * Copyright (c) 2018. syshlang
 * @File: canvas_star.js
 * @Description:
 * @Author: sunys
 * @Date: 18-8-23 下午8:26
 * @since:
 */

// Options
var options = {
    /* Which hue should be used for the first batch of rockets? */
    startingHue: 120,
    /* How many ticks the script should wait before a new firework gets spawned, if the user is holding down his mouse button. */
    clickLimiter: 5,
    /* How fast the rockets should automatically spawn, based on ticks */
    timerInterval: 40,
    /* Show pulsing circles marking the targets? */
    showTargets: true,
    /* Rocket movement options, should be self-explanatory */
    rocketSpeed: 2,
    rocketAcceleration: 1.03,
    /* Particle movement options, should be self-explanatory */
    particleFriction: 0.95,
    particleGravity: 1,
    /* Minimum and maximum amount of particle spawns per rocket */
    particleMinCount: 25,
    particleMaxCount: 40,
    /* Minimum and maximum radius of a particle */
    particleMinRadius: 3,
    particleMaxRadius: 5
};

// Local variables
var fireworks = [];
var particles = [];
var mouse = {down: false, x: 0, y: 0};
var currentHue = options.startingHue;
var clickLimiterTick = 0;
var timerTick = 0;
var cntRocketsLaunched = 0;

// Helper function for canvas animationscanvas
window.requestAnimFrame = (function() {
    return window.requestAnimationFrame ||
        window.webkitRequestAnimationFrame ||
        window.mozRequestAnimationFrame ||
        function(cb) {
            window.setTimeout(callback, 1000 / 60);
        }
})();

// Helper function to return random numbers within a specified range
function random(min, max) {
    return Math.random() * (max - min) + min;
}

// Helper function to calculate the distance between 2 points
function calculateDistance(p1x, p1y, p2x, p2y) {
    var xDistance = p1x - p2x;
    var yDistance = p1y - p2y;
    return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
}

// Setup some basic variables
var canvas = document.getElementById('canvas');
var canvasCtx = canvas.getContext('2d');
var canvasWidth = window.innerWidth;
var canvasHeight = window.innerHeight;

// Resize canvas
canvas.width = canvasWidth;
canvas.height = canvasHeight;

// Firework class
function Firework(sx, sy, tx, ty) {
    // Set coordinates (x/y = actual, sx/sy = starting, tx/ty = target)
    this.x = this.sx = sx;
    this.y = this.sy = sy;
    this.tx = tx; this.ty = ty;

    // Calculate distance between starting and target point
    this.distanceToTarget = calculateDistance(sx, sy, tx, ty);
    this.distanceTraveled = 0;

    // To simulate a trail effect, the last few coordinates will be stored
    this.coordinates = [];
    this.coordinateCount = 3;

    // Populate coordinate array with initial data
    while(this.coordinateCount--) {
        this.coordinates.push([this.x, this.y]);
    }

    // Some settings, you can adjust them if you'd like to do so.
    this.angle = Math.atan2(ty - sy, tx - sx);
    this.speed = options.rocketSpeed;
    this.acceleration = options.rocketAcceleration;
    this.brightness = random(50, 80);
    this.hue = currentHue;
    this.targetRadius = 1;
    this.targetDirection = false;  // false = Radius is getting bigger, true = Radius is getting smaller

    // Increase the rockets launched counter
    cntRocketsLaunched++;
};

// This method should be called each frame to update the firework
Firework.prototype.update = function(index) {
    // Update the coordinates array
    this.coordinates.pop();
    this.coordinates.unshift([this.x, this.y]);

    // Cycle the target radius (used for the pulsing target circle)
    if(!this.targetDirection) {
        if(this.targetRadius < 8)
            this.targetRadius += 0.15;
        else
            this.targetDirection = true;
    } else {
        if(this.targetRadius > 1)
            this.targetRadius -= 0.15;
        else
            this.targetDirection = false;
    }

    // Speed up the firework (could possibly travel faster than the speed of light)
    this.speed *= this.acceleration;

    // Calculate the distance the firework has travelled so far (based on velocities)
    var vx = Math.cos(this.angle) * this.speed;
    var vy = Math.sin(this.angle) * this.speed;
    this.distanceTraveled = calculateDistance(this.sx, this.sy, this.x + vx, this.y + vy);

    // If the distance traveled (including velocities) is greater than the initial distance
    // to the target, then the target has been reached. If that's not the case, keep traveling.
    if(this.distanceTraveled >= this.distanceToTarget) {
        createParticles(this.tx, this.ty);
        fireworks.splice(index, 1);
    } else {
        this.x += vx;
        this.y += vy;
    }
};

// Draws the firework
Firework.prototype.draw = function() {
    var lastCoordinate = this.coordinates[this.coordinates.length - 1];

    // Draw the rocket
    canvasCtx.beginPath();
    canvasCtx.moveTo(lastCoordinate[0], lastCoordinate[1]);
    canvasCtx.lineTo(this.x, this.y);
    canvasCtx.strokeStyle = 'hsl(' + this.hue + ',100%,' + this.brightness + '%)';
    canvasCtx.stroke();

    // Draw the target (pulsing circle)
    if(options.showTargets) {
        canvasCtx.beginPath();
        canvasCtx.arc(this.tx, this.ty, this.targetRadius, 0, Math.PI * 2);
        canvasCtx.stroke();
    }
};

// Particle class
function Particle(x, y) {
    // Set the starting point
    this.x = x;
    this.y = y;

    // To simulate a trail effect, the last few coordinates will be stored
    this.coordinates = [];
    this.coordinateCount = 5;

    // Populate coordinate array with initial data
    while(this.coordinateCount--) {
        this.coordinates.push([this.x, this.y]);
    }

    // Set a random angle in all possible directions (radians)
    this.angle = random(0, Math.PI * 2);
    this.speed = random(1, 10);

    // Add some friction and gravity to the particle
    this.friction = options.particleFriction;
    this.gravity = options.particleGravity;

    // Change the hue to a random number
    this.hue = random(currentHue - 20, currentHue + 20);
    this.brightness = random(50, 80);
    this.alpha = 1;

    // Set how fast the particles decay
    this.decay = random(0.01, 0.03);
}

// Updates the particle, should be called each frame
Particle.prototype.update = function(index) {
    // Update the coordinates array
    this.coordinates.pop();
    this.coordinates.unshift([this.x, this.y]);

    // Slow it down (based on friction)
    this.speed *= this.friction;

    // Apply velocity to the particle
    this.x += Math.cos(this.angle) * this.speed;
    this.y += Math.sin(this.angle) * this.speed + this.gravity;

    // Fade out the particle, and remove it if alpha is low enough
    this.alpha -= this.decay;
    if(this.alpha <= this.decay) {
        particles.splice(index, 1);
    }
}

// Draws the particle
Particle.prototype.draw = function() {
    var lastCoordinate = this.coordinates[this.coordinates.length - 1];
    var radius = Math.round(random(options.particleMinRadius, options.particleMaxRadius));

    // Create a new shiny gradient
    var gradient = canvasCtx.createRadialGradient(this.x, this.y, 0, this.x, this.y, radius);
    gradient.addColorStop(0.0, 'white');
    gradient.addColorStop(0.1, 'white');
    gradient.addColorStop(0.1, 'hsla(' + this.hue + ',100%,' + this.brightness + '%,' + this.alpha + ')');
    gradient.addColorStop(1.0, 'black');

    // Draw the gradient
    canvasCtx.beginPath();
    canvasCtx.fillStyle = gradient;
    canvasCtx.arc(this.x, this.y, radius, Math.PI * 2, false);
    canvasCtx.fill();
}

// Create a bunch of particles at the given position
function createParticles(x, y) {
    var particleCount = Math.round(random(options.particleMinCount, options.particleMaxCount));
    while(particleCount--) {
        particles.push(new Particle(x, y));
    }
}

// Add an event listener to the window so we're able to react to size changes
window.addEventListener('resize', function(e) {
    canvas.width = canvasWidth = window.innerWidth;
    canvas.height = canvasHeight = window.innerHeight;
});

// Add event listeners to the canvas to handle mouse interactions
canvas.addEventListener('mousemove', function(e) {
    e.preventDefault();
    mouse.x = e.pageX - canvas.offsetLeft;
    mouse.y = e.pageY - canvas.offsetTop;
});

canvas.addEventListener('mousedown', function(e) {
    e.preventDefault();
    mouse.down = true;
});

canvas.addEventListener('mouseup', function(e) {
    e.preventDefault();
    mouse.down = false;
});

// Main application / script, called when the window is loaded
function gameLoop() {
    // This function will rund endlessly by using requestAnimationFrame (or fallback to setInterval)
    requestAnimFrame(gameLoop);

    // Increase the hue to get different colored fireworks over time
    currentHue += 0.5;

    // 'Clear' the canvas at a specific opacity, by using 'destination-out'. This will create a trailing effect.
    canvasCtx.globalCompositeOperation = 'destination-out';
    canvasCtx.fillStyle = 'rgba(0, 0, 0, 0.5)';
    canvasCtx.fillRect(0, 0, canvasWidth, canvasHeight);
    canvasCtx.globalCompositeOperation = 'lighter';

    // Loop over all existing fireworks (they should be updated & drawn)
    var i = fireworks.length;
    while(i--) {
        fireworks[i].draw();
        fireworks[i].update(i);
    }

    // Loop over all existing particles (they should be updated & drawn)
    var i = particles.length;
    while(i--) {
        particles[i].draw();
        particles[i].update(i);
    }

    // Draw some text
    canvasCtx.fillStyle = 'white';
    canvasCtx.font = '14px Arial';
    //canvasCtx.fillText('Rockets launched: ' + cntRocketsLaunched, 10, 24);

    // Launch fireworks automatically to random coordinates, if the user does not interact with the scene
    if(timerTick >= options.timerInterval) {
        if(!mouse.down) {
            fireworks.push(new Firework(canvasWidth / 2, canvasHeight, random(0, canvasWidth), random(0, canvasHeight / 2)));
            timerTick = 0;
        }
    } else {
        timerTick++;
    }

    // Limit the rate at which fireworks can be spawned by mouse
    if(clickLimiterTick >= options.clickLimiter) {
        if(mouse.down) {
            fireworks.push(new Firework(canvasWidth / 2, canvasHeight, mouse.x, mouse.y));
            clickLimiterTick = 0;
        }
    } else {
        clickLimiterTick++;
    }
}
/*********************************************************************************/
var can = document.getElementById('canvas');
var cxt = can.getContext('2d');

var w = can.width = window.innerWidth;
var h = can.height = window.innerHeight;

var num = 200; //生成点的个数
var data = []; //定义一个数组，准备用来存坐标
var move = {};
var liuXY = [];
var k = -1;
var range = Math.atan(k);
var length = 200;

//生成num个点，并且存储初始坐标
for (var i = 0; i < num; i++) {
    data[i] = {
        x: Math.random() * w,
        y: Math.random() * h,
        r: Math.random() * 8 + 3
    };
    Cricle(data[i].x, data[i].y, data[i].r);
};

! function draw() {
    cxt.clearRect(0, 0, w, h);
    for (var i = 0; i < num; i++) {
        data[i].r += Math.random() * 2 - 1;
        data[i].r = Math.max(0, data[i].r);
        data[i].r = Math.min(12, data[i].r);
        Cricle(data[i].x, data[i].y, data[i].r);
    };
    if (liuXY.length) {
        for (var i in liuXY) {
            liuXY[i].cX -= 10;
            liuX(liuXY[i].cX, liuXY[i].y, liuXY[i].x);
            if (liuXY[i].cX < 0 || getY(liuXY[i].cX, liuXY[i].y, liuXY[i].x) > h) {
                liuXY.splice(i, 1);
            };
        };
    };
    if (Math.random() > 0.98) {
        var a = Math.random() * (w - 400) + 400;
        liuXY.push({
            x: a,
            y: 0,
            cX: a
        });
    };
    window.requestAnimationFrame(draw);
}();

function liuX(x, sX, sY) {
    cxt.save();
    var y = getY(x, sY, sX);
    var r = 15;
    var rad = cxt.createRadialGradient(x, y, 0, x, y, r);
    rad.addColorStop(0, 'rgba(255,255,255,0.8)');
    rad.addColorStop(0.1, 'rgba(255,255,255,0.8)');
    rad.addColorStop(0.2, 'rgba(255,255,255,0.08)');
    rad.addColorStop(1, 'rgba(255,255,255,0)');
    cxt.fillStyle = rad;
    cxt.beginPath();
    cxt.arc(x, y, r, 0, 2 * Math.PI, true);
    cxt.closePath();
    cxt.fill();
    cxt.restore();

    var wX = x + (Math.cos(range) * length);
    var wY = y + (Math.sin(range) * length);

    var x1 = x + 3;
    var y1 = y;
    var x2 = x;
    var y2 = y - 3;

    cxt.save();
    var rad2 = cxt.createRadialGradient(x, y, 0, x, y, length);
    rad2.addColorStop(0, 'rgba(255,255,255,0.1)');
    rad2.addColorStop(1, 'rgba(255,255,255,0)');
    cxt.fillStyle = rad2;
    cxt.beginPath();
    cxt.moveTo(x1, y1);
    cxt.lineTo(x2, y2);
    cxt.lineTo(wX, wY);
    cxt.closePath();
    cxt.fill();
    cxt.restore();
};

function getY(x, startY, startX) {
    return k * x + startY - k * startX;
};

//画点
function Cricle(x, y, r) {
    cxt.save();
    var rad = cxt.createRadialGradient(x, y, 0, x, y, r);
    rad.addColorStop(0, 'rgba(255,255,255,0.8)');
    rad.addColorStop(0.1, 'rgba(255,255,255,0.8)');
    rad.addColorStop(0.2, 'rgba(255,255,255,0.08)');
    rad.addColorStop(1, 'rgba(255,255,255,0)');
    cxt.fillStyle = rad;
    cxt.beginPath();
    cxt.arc(x, y, r, 0, 2 * Math.PI, true);
    cxt.closePath();
    cxt.fill();
    cxt.restore();
};

window.onload = gameLoop();