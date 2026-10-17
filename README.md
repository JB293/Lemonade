# Lemonade App 🍋

Une application Android interactive et ludique qui simule le processus de fabrication d'une citronnade, de la cueillette du fruit à la dégustation.

Ce projet a été conçu pour illustrer la gestion des états (State) dans Compose et l'utilisation des structures de contrôle conditionnelles en Kotlin.

## Fonctionnalités

*   **Logique séquentielle** : L'utilisateur doit suivre les étapes dans l'ordre (Cueillir, Presser, Boire, Recommencer).
*   **Interaction dynamique** : L'étape de pressage nécessite plusieurs clics (aléatoires) pour simuler l'effort de presser un citron.
*   **Interface Réactive** : L'UI se met à jour instantanément grâce à `remember` et `mutableStateOf`.
*   **Design Material 3** : Utilisation des composants et de la thématisation moderne.

## Captures d'écran

| 1. Cueillir | 2. Presser | 3. Boire | 4. Recommencer |
| :---: | :---: | :---: | :---: |
| ![Étape 1](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-lemonade-app/img/93b21696417f7d18.png) | ![Étape 2](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-lemonade-app/img/39e946e3962d35e1.png) | ![Étape 3](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-lemonade-app/img/76632497676757f5.png) | ![Étape 4](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-lemonade-app/img/a67895e7c8f94d21.png) |

## Stack Technique

*   **Langage** : [Kotlin](https://kotlinlang.org/)
*   **UI Framework** : [Jetpack Compose](https://developer.android.com/jetpack/compose)
*   **Design System** : Material Design 3 (M3)

## Structure du Code

L'application repose sur un état principal (`step`) qui détermine le contenu affiché :


## Installation

1. Clonez ce dépôt :
   ```bash
   git clone https://github.com/votre-utilisateur/lemonade-app.git
   ```
2. Ouvrez le projet dans **Android Studio (Ladybug ou version ultérieure)**.
3. Synchronisez le projet avec les fichiers Gradle.
4. Lancez l'application sur un émulateur ou un appareil physique (API 24+).

## Concepts Appris

*   Utilisation des fonctions composables.
*   Gestion des ressources (Images et Chaînes de caractères).
*   Gestion des événements de clic (`Modifier.clickable`).
*   Logique conditionnelle pour naviguer entre les écrans sans Navigation Component (State-driven UI).