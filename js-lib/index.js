'use strict';

function lateFee(daysKept) {
  const daysLate = daysKept - 14;
  return daysLate <= 0 ? 0 : Math.min(daysLate * 0.5, 10);
}

module.exports = { lateFee };
