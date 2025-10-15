package Week6;

record Statistics(String countryName, double density) {
    public static Statistics of(Country country) {
        return new Statistics(country.countryName(), country.population() * 1000_000 / country.area());
    }
}
