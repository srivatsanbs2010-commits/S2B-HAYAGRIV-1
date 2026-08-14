# S2B Hayagriva — Flat Android Project

This is a deliberately flat Android Gradle project.

All project files are at the ZIP root:
- build.gradle.kts
- settings.gradle.kts
- gradle.properties
- AndroidManifest.xml
- MainActivity.kt
- proguard-rules.pro
- main.yml

The Android module is the root project, so the debug task is:

    gradle assembleDebug

NOT:

    gradle :app:assembleDebug

## GitHub Actions

GitHub only executes workflow files from:

    .github/workflows/

Therefore `main.yml` is intentionally at the ZIP root to satisfy the
"no subfolders" requirement. To make GitHub Actions execute it, move/copy
`main.yml` to `.github/workflows/main.yml` after uploading the flat files.

No Codespaces is required.
