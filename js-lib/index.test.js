'use strict';

const test = require('node:test');
const assert = require('node:assert');
const { lateFee } = require('./index');

test('no fee within 14 days', () => {
  assert.strictEqual(lateFee(0), 0);
  assert.strictEqual(lateFee(14), 0);
});

test('half a unit per day after 14 days', () => {
  assert.strictEqual(lateFee(20), 3);
});

test('the fee is capped at 10', () => {
  assert.strictEqual(lateFee(100), 10);
});
