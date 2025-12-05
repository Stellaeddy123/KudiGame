package pt.iade.ei.kudigame.model

import pt.iade.ei.kudigame.R




object SampleData {
    val games: List<Game> = listOf(
        Game(
            id = "g1",
            title = "Diablo IV",
            genre = "Action / RPG",
            shortDescription = "Participa na luta por Santuário em Diablo IV.",
            imageRestName = R.drawable.diablo_4_banner, // coloca arquivo em drawable
            storeItems = listOf(
                StoreItem(
                    "c1",
                    "Diablo® IV: Vessel of Hatred™",
                    "Desvenda o próximo capítulo de Diablo IV em Vessel of Hatred",
                    13.99,
                    R.drawable.diablo_item_2
                ),
                StoreItem(
                    "c2",
                    "Diablo IV - Banda Sonora",
                    "Recorda a eterna batalha entre o Paraíso Celestial",
                    10.99,
                    R.drawable.diablo_item_3
                ),
                StoreItem(
                    "c3",
                    "Diablo IV - Pacote de Platina Tesouro do Rebelde",
                    "Os caçadores de tesouros de Nahantu encontram ",
                    6.99,
                    R.drawable.diablo_item_4
                )
            )
        ),
        Game(
            id = "g2",
            title = "Warhammer 40,000: Space Marine 2",
            genre = "Ação, Aventura, RPG",
            shortDescription = "Embody the superhuman skill and brutality of a Space Marine.",
            imageRestName = R.drawable.space_marine_2_banner,
            storeItems = listOf(
                StoreItem(
                    "m1",
                    "Warhammer 40,000: Space Marine 2",
                    "Space Marine chapters through four phases",
                    29.99,
                    R.drawable.space_marine_item_1
                ),
                StoreItem(
                    "m2",
                    "Warhammer 40,000: Space Marine 2 - Imperial Fists Cosmetic Pack",
                    "Honour your Chapter's proud martial heritage with the Imperial Fists Cosmetic Pack",
                    4.99,
                    R.drawable.space_marine_item_2
                ),
                StoreItem(
                    "m3",
                    "Blood Angels Champion Pack",
                    "Gameplay consists of frequent combat scenarios",
                    7.99,
                    R.drawable.space_marine_item_3

                )
            )
        )
    )
}