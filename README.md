# AdvancementInteraction

![Minecraft](https://img.shields.io/badge/Minecraft-1.20.2-4CAF50?style=for-the-badge&logo=minecraft&logoColor=white)
![API](https://img.shields.io/badge/API-Paper%20%7C%20Spigot-2c2f33?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-16+-orange?style=for-the-badge&logo=openjdk&logoColor=white)
[![Build](https://img.shields.io/github/actions/workflow/status/The-Mats/AdvancementInteraction/build.yml?branch=master&style=for-the-badge&label=build)](https://github.com/The-Mats/AdvancementInteraction/actions/workflows/build.yml)
[![Latest build](https://img.shields.io/badge/download-latest%20jar-success?style=for-the-badge)](https://github.com/The-Mats/AdvancementInteraction/releases/download/latest/AdvancementInteraction-1.20.2.jar)

A small NMS plugin that abstracts sending fake, positioned advancements over raw packets — the annoying, version-specific part of building a custom advancement-tab UI (like a team's own tab, or a Bingo-style board) is handled here so other plugins never need to touch NMS themselves.

> [!NOTE]
> This plugin is meant to be depended on by other plugins, not used standalone. Send advancements to arbitrary custom locations on a player's advancement screen, grant/revoke them, and build per-team advancement trees — all through a plain Bukkit-facing API with zero NMS exposure to the calling plugin. See [Bingo](https://github.com/The-Mats/Bingo) for a real integration (per-team advancement boards + a fake-vs-real advancement filter).

## Requirements

- Paper or Spigot **1.20.2**
- Java 16+

## Download

Grab the latest build from `master`: **[AdvancementInteraction-1.20.2.jar](https://github.com/The-Mats/AdvancementInteraction/releases/download/latest/AdvancementInteraction-1.20.2.jar)**

Built automatically on every push to `master` — see [Building](#building) if you'd rather build it yourself.

## Building

This plugin talks to Minecraft's internals (NMS), so it needs a locally-built, remapped server jar that isn't available on any public Maven repository:

```bash
java -jar BuildTools.jar --rev 1.20.2 --remapped
mvn clean package
```

The final jar ends up at `target/AdvancementInteraction-1.0-SNAPSHOT.jar`.

## Development server (Docker)

Instead of setting up and updating your own test server by hand, a ready-to-go Paper 1.20.2 server lives under `docker/`:

```bash
cd docker
docker compose up -d
```

`mvn package` automatically copies the freshly built jar into `docker/data/plugins/`, so a rebuild + `docker compose down && docker compose up -d` is all it takes to test a change end to end. `down`/`up` (not `stop`/`up`) is intentional — restarting the same container can occasionally serve a stale jar to the already-open JVM.
