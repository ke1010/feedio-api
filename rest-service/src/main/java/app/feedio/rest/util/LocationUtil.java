package app.feedio.rest.util;

public final class LocationUtil {

    private static final int EARTH_RADIUS_KM = 6371;

    // Private constructor prevents instantiation
    private LocationUtil() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Calculates the distance between two geographical points using the Haversine formula.
     * @return Distance in kilometers
     */
    public static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    /**
     * Helper to estimate delivery time based on distance.
     */
    public static int estimateDeliveryTimeInMins(double distanceKm) {
        return (int) (15 + (distanceKm * 5)); // Base 15 mins + 5 mins per km
    }
}
