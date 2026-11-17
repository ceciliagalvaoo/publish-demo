using LendIt.Pricing;

namespace LendIt.Pricing.Tests;

public class LateFeeTests
{
    [Theory]
    [InlineData(0)]
    [InlineData(14)]
    public void No_fee_within_14_days(int daysKept)
    {
        Assert.Equal(0m, LateFee.Calculate(daysKept));
    }

    [Fact]
    public void Half_a_unit_per_day_after_14_days()
    {
        Assert.Equal(3.00m, LateFee.Calculate(20));
    }

    [Fact]
    public void Fee_is_capped_at_10()
    {
        Assert.Equal(10.00m, LateFee.Calculate(100));
    }
}
