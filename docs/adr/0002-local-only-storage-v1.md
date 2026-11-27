# Local-only storage for v1 using SQLDelight

All data (Fridge Items, Shopping List, Settings) is stored on-device using SQLDelight, a KMP-native SQL library. There is no backend, no user account, and no cloud sync in v1.

This was chosen to eliminate backend infrastructure costs and complexity for the initial release, to ship faster, and because local-only is a genuine marketing advantage in Germany where "Keine Cloud, keine Registrierung" (no cloud, no registration) is a strong privacy signal. SQLDelight is the natural database choice for Kotlin Multiplatform as it generates type-safe Kotlin from SQL and targets both Android and iOS from shared code.

Cloud sync is the most requested future feature and is planned as a v2 Premium Tier addition once the core product is validated.

**Considered options**: Room (Android-only, breaks the KMP shared module), Realm (cross-platform but heavier dependency), Firebase (requires accounts and internet, contradicts the privacy angle).