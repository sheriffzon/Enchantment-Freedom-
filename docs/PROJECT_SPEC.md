# Enchantment Freedom — Implementation Specification

## Target
- Minecraft Java Edition 26.2
- Fabric Loader
- Java 25
- Mod ID: `enchantment_freedom`
- Package: `com.sheriffzon.enchantmentfreedom`

## Required behaviour

1. Raise vanilla enchantment maximum levels to X (10), including actual gameplay effects and correct tooltip display.
2. Allow enchantments to coexist regardless of vanilla incompatibility, including Sharpness/Smite, Depth Strider/Frost Walker, and Infinity/Mending.
3. Permit enchantments on normally unsupported items, including Protection on Elytra.
4. Remove the anvil's vanilla "Too Expensive!" experience-level ceiling while preserving normal anvil operations.
5. Combining two copies of the same enchantment at the same level produces the next level: V+V=VI through IX+IX=X. Unequal levels do not advance. Never exceed X.
6. Librarians may offer enchanted books for all vanilla enchantments at levels I–X. Higher levels must be progressively rarer; level X should be exceptionally rare.

## Engineering requirements

- Standalone Fabric mod; no Carpet, Forge, or NeoForge dependency.
- Validate all mixin targets and method descriptors against Minecraft 26.2.
- Preserve enchantments in item stacks, books, inventories, containers, and saved worlds.
- Handle modded enchantments where technically possible without hardcoding only vanilla IDs.
- Avoid unnecessary changes to unrelated vanilla behaviour.
- Do not implement cosmetic-only level changes: high levels must affect gameplay.
- Document limitations and test coverage honestly.

## Verification checklist

- [ ] Builds successfully against Minecraft 26.2.
- [ ] Starts without mixin errors.
- [ ] Level X is obtainable and functions.
- [ ] Incompatible enchantments coexist and remain after relogging.
- [ ] Enchantments can be applied to normally unsupported items.
- [ ] Expensive anvil operations are usable.
- [ ] Equal-level combining follows the specified progression.
- [ ] Librarian trades can generate levels I–X with weighted rarity.

A successful compilation is not proof of in-game correctness. Mark features complete only after the corresponding behaviour has been tested.
