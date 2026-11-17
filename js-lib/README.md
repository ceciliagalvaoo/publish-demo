# @ceciliagalvaoo/lendit-pricing

Late fee calculation for LendIt: 0.50 per day after 14 days, at most 10.00.

```javascript
const { lateFee } = require('@ceciliagalvaoo/lendit-pricing');
lateFee(20); // 3
```
