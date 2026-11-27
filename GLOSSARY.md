# Thyme

A Kotlin Multiplatform (Android + iOS) app that helps a solo user track what's in their fridge, get recipe suggestions, monitor nutrition, and manage their shopping list. The name is a deliberate double meaning: thyme the herb (food) and "time" (expiry tracking).

## Language

**Fridge Item**:
A food or drink product currently stored in the user's fridge, with a name, quantity, expiry date, and **Macros**.
_Avoid_: product, ingredient, entry

**Barcode Scan**:
The primary method of adding a **Fridge Item**, using the device camera to read a product barcode and auto-fill its details from a product database.
_Avoid_: scan, QR scan

**Expiry Date**:
The date by which a **Fridge Item** should be consumed, used to generate expiry alerts.
_Avoid_: best-before, use-by

**Macros**:
The nutritional profile of a **Fridge Item** or **Recipe**, comprising calories, protein, carbohydrates, and fat.
_Avoid_: nutrition, nutritional info, calories

**Recipe Suggestion**:
A cooking recommendation generated from the user's current **Fridge Items**, permitted to require up to 1–2 ingredients not currently in the fridge.
_Avoid_: recipe, meal suggestion

**Missing Ingredient**:
An ingredient required by a **Recipe Suggestion** that is not currently a **Fridge Item**; automatically added to the **Shopping List**.
_Avoid_: needed ingredient, out-of-stock ingredient

**Shopping List**:
A list of items to buy, populated automatically from **Missing Ingredients** in **Recipe Suggestions**.
_Avoid_: grocery list, buy list

**Free Tier**:
The base feature set available to all users at no cost: inventory management and expiry tracking.
_Avoid_: free plan, basic plan

**Premium Tier**:
The paid feature set unlocked via a one-time in-app purchase: **Recipe Suggestions**, **Macros** tracking, and **Shopping List**.
_Avoid_: pro plan, paid plan, subscription

**Quantity**:
How much of a **Fridge Item** the user has, expressed as a count (e.g. "3 yogurts") or a weight/volume (e.g. "500g", "1.5L") depending on the item type.
_Avoid_: amount, stock, units

**Shelf Life Suggestion**:
The app's estimated expiry duration for a **Fridge Item** based on its product category from Open Food Facts, offered as a one-tap default when the user scans a barcode.
_Avoid_: default expiry, estimated expiry

**Dietary Preference**:
A single global filter applied to all **Recipe Suggestions** (e.g. vegetarian, gluten-free), set once in Settings.
_Avoid_: diet filter, food preference

**Daily Macro Goal**:
An optional personal target for daily calorie and macro intake, set in Settings. Off by default; a **Premium Tier** feature.
_Avoid_: calorie goal, nutrition target

**Premium Gate**:
The screen shown when a **Free Tier** user taps the Rezepte (Recipes) tab, explaining the **Premium Tier** and offering the one-time in-app purchase.
_Avoid_: paywall, upgrade screen