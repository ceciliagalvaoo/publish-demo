# LendIt.Pricing

Late fee calculation for LendIt: 0.50 per day after 14 days, at most 10.00.

```csharp
using LendIt.Pricing;

decimal fee = LateFee.Calculate(daysKept: 20);   // 3.00
```
