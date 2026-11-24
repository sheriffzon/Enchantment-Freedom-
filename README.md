# Enchantment Freedom

A Fabric mod for Minecraft 26.2 that removes several vanilla enchantment restrictions.

## Features

- Raises the maximum level reported by enchantments to X, including supported modded enchantments.
- Allows otherwise incompatible enchantments to coexist.
- Allows enchantments to be applied to items outside their normal supported-item lists.
- Removes the vanilla anvil "Too Expensive!" level-40 cutoff.
- Vanilla anvil combining upgrades equal enchantment levels by one, up to X (for example, V + V becomes VI). Minecraft's normal anvil merge logic performs this using the raised maximum level.
- Adds Soul Speed, Swift Sneak, and Wind Burst to the vanilla tradeable-enchantment tag, making all vanilla enchantments eligible for librarian book trades.
- Raises enchanted-book trade levels with progressively lower odds at higher levels; level X is exceptionally rare.

## Compatibility

- Minecraft Java Edition 26.2
- Fabric Loader 0.19.5 or newer
- Fabric API
- Java 25 or newer

## Installation

1. Install Fabric for Minecraft 26.2 and the matching Fabric API.
2. Put the Enchantment Freedom JAR in the instance's `mods` folder.
3. Launch the game with the Fabric profile.

## Test-build checklist

This is a test build, not a gameplay-verified release. Back up worlds before testing. Please check:
- Loading into an existing world and creating a new world.
- Combining equal-level books/items at levels V through X.
- Combining different levels (they should keep the higher level without upgrading).
- Applying normally incompatible enchantments together.
- Applying enchantments to unusual items, including Protection on Elytra.
- Librarian trades for Soul Speed, Swift Sneak, and Wind Burst, and the frequency of high-level books.
- Anvil operations whose XP cost exceeds 40.

Report any crash log or unexpected result with the exact action that caused it.

## Building

The GitHub Actions workflow builds the mod with Java 25. Download the artifact named `enchantment-freedom-build` from a successful workflow run.
