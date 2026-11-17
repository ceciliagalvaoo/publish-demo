'use strict';

const { lateFee } = require('@ceciliagalvaoo/lendit-pricing');
console.log(`Late fee for 20 days: ${lateFee(20)}`);
