# publish-demo

[![publish-packages](https://github.com/ceciliagalvaoo/publish-demo/actions/workflows/publish-packages.yml/badge.svg)](https://github.com/ceciliagalvaoo/publish-demo/actions/workflows/publish-packages.yml)

Applied DevOps – Lab 8. Three tiny libraries with the same logic (the LendIt **late fee**: 0.50 per day after 14 days, at most 10.00), published as native packages to **GitHub Packages** by one pipeline.

| Folder | Package | Registry | Test |
|---|---|---|---|
| [`dotnet-lib/`](dotnet-lib) | `LendIt.Pricing` (`.nupkg` with a `.dll`) | `https://nuget.pkg.github.com/ceciliagalvaoo/index.json` | `dotnet test dotnet-lib/tests/LendIt.Pricing.Tests` |
| [`java-lib/`](java-lib) | `hr.lendit:lendit-pricing` (`.jar` + sources) | `https://maven.pkg.github.com/ceciliagalvaoo/publish-demo` | `cd java-lib && ./mvnw test` |
| [`js-lib/`](js-lib) | `@ceciliagalvaoo/lendit-pricing` | `https://npm.pkg.github.com` | `cd js-lib && npm test` |

- Versions and channels (`dev`, `rc`, `release`): [`docs/versioning.md`](docs/versioning.md), computed by [`.github/scripts/version.sh`](.github/scripts/version.sh).
- Pipeline: [`.github/workflows/publish-packages.yml`](.github/workflows/publish-packages.yml) – push to `main` → `X.Y.0-dev.N`; tag `vX.Y.Z-rc.N` → rc; tag `vX.Y.Z` → release (waits for approval of the `production` environment).
- Consumers that install the packages: [`consumers/`](consumers) (`dotnet`, `node`, `maven`); they read the token from the `GITHUB_TOKEN` environment variable (a PAT with `read:packages`), nothing secret is committed.
- Lab report: [`docs/publishing-lab.md`](docs/publishing-lab.md).
