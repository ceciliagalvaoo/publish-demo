namespace LendIt.Pricing;

public static class LateFee
{
    public static decimal Calculate(int daysKept)
    {
        var daysLate = daysKept - 14;
        return daysLate <= 0 ? 0m : Math.Min(daysLate * 0.50m, 10.00m);
    }
}
