# Thyme

> Know what's in your fridge. Cook healthy. Waste nothing.

Thyme is a Kotlin Multiplatform app (Android + iOS) for fridge inventory tracking, macro-aware recipe suggestions, expiry alerts, and a smart shopping list — no account, no cloud, no subscription.

The name is a double meaning: **thyme** the herb and **time** (expiry tracking).

## What we're building

| Feature | Tier |
|---|---|
| Fridge inventory — barcode scan, name search, manual entry | Free |
| Expiry alerts — push notification 3 days before | Free |
| Recipe suggestions based on what's in your fridge (Spoonacular) | Premium |
| Macros per item and per recipe | Premium |
| Shopping list with REWE + Amazon Fresh DE links | Premium |
| Daily Macro Goal tracking | Premium |

Premium is a one-time €3.99 in-app purchase — no subscription.

## Progress

All planned work is tracked as GitHub Issues with explicit blocking edges, so you can see exactly what's in progress, what's ready to start, and what's waiting.

**[View all issues →](https://github.com/golnaaz/thyme-app/issues)**

The 12 tickets that make up the MVP, in dependency order:

| # | Ticket | Status |
|---|---|---|
| [#1](https://github.com/golnaaz/thyme-app/issues/1) | SQLDelight database — FridgeItem schema and CRUD | ready |
| [#2](https://github.com/golnaaz/thyme-app/issues/2) | App shell — 4-tab navigation | ready |
| [#3](https://github.com/golnaaz/thyme-app/issues/3) | Barcode Scan to add a Fridge Item | blocked by #1, #2 |
| [#4](https://github.com/golnaaz/thyme-app/issues/4) | Name search + manual entry for Fridge Items | blocked by #1, #2 |
| [#5](https://github.com/golnaaz/thyme-app/issues/5) | Fridge Item detail — edit, delete, used-up prompt | blocked by #3 |
| [#6](https://github.com/golnaaz/thyme-app/issues/6) | Expiry push notifications — Free Tier | blocked by #1 |
| [#7](https://github.com/golnaaz/thyme-app/issues/7) | Einstellungen screen | blocked by #2 |
| [#8](https://github.com/golnaaz/thyme-app/issues/8) | Premium Gate + €3.99 one-time IAP | blocked by #2 |
| [#9](https://github.com/golnaaz/thyme-app/issues/9) | Rezepte tab — Recipe Suggestions via Spoonacular | blocked by #3, #7, #8 |
| [#10](https://github.com/golnaaz/thyme-app/issues/10) | Einkaufsliste — Shopping List with REWE + Amazon Fresh DE | blocked by #9 |
| [#11](https://github.com/golnaaz/thyme-app/issues/11) | Macros per Fridge Item + Daily Macro Goal | blocked by #9 |
| [#12](https://github.com/golnaaz/thyme-app/issues/12) | Premium expiry notifications with Recipe Suggestion deep-link | blocked by #6, #8 |

## How the design was created

The product was designed through a structured interview process ([grilling](https://github.com/mattpocock/skills)) that asked questions in rounds — each round settling decisions that unblocked the next set of questions. Every key decision is recorded in `docs/adr/` and domain vocabulary is captured in `GLOSSARY.md`.

- [`GLOSSARY.md`](./GLOSSARY.md) — canonical terms for the project
- [`docs/adr/`](./docs/adr/) — key decisions and why they were made

## Tech stack

- **Language**: Kotlin Multiplatform (Android + iOS)
- **UI**: Compose Multiplatform
- **Database**: SQLDelight (local only, no cloud)
- **Barcode data**: Open Food Facts (free, open-source)
- **Recipes**: Spoonacular API
- **Notifications**: WorkManager (Android) + UserNotifications (iOS)
- **IAP**: Google Play Billing + StoreKit 2

## Running the apps

- Android: `./gradlew :androidApp:assembleDebug`
- iOS: open `/iosApp` in Xcode and run

## Running tests

- Android: `./gradlew :shared:testAndroidHostTest`
- iOS: `./gradlew :shared:iosSimulatorArm64Test`
