
import kotlin.random.Random.Default.nextInt


open class Job{
    var jobName = ""
    var ability1 = ""
    var ability2 = ""
    var ability1Dmg = 0
    var ability2Dmg = 0
}

class Player : Job() {
    var playerName = ""
    var playerHealth = 100
    var playerLevel = 1
    var playerExp = 0
}

fun introDescription(){
    println("Welcome to the world of One, Hero!")
    println("This is the destination for all who have died in their own world")
    println("Here you can live out your dreams as an adventurer!")
    println("Visit new locations, hunt monsters, rest, and do it all over again!")
    println("A grand afterlife adventure awaits you here in the world of ONE!")
}

fun displayJobInfo(){
    println("==============||===||==============")
    println("Job: Warrior")
    println("-Description-")
    println("High Health and Average Attack")
    println("The abilities are slash and crush.")
    println("==============||===||==============")

    println("==============||===||==============")
    println("Job: Thief")
    println("-Description-")
    println("Low Health and High Attack")
    println("The abilities are Double-Cut and Assassinate")
    println("==============||===||==============")

    println("==============||===||==============")
    println("Job: Archer")
    println("-Description-")
    println("Average Health and Above Average Attack")
    println("The abilities are Arrow Shot and Snipe")
    println("==============||===||==============")

    println("==============||===||==============")
    println("-Job: Mage-")
    println("-Description-")
    println("Very Low Health and Very High Attack")
    println("The abilities are Magic Bolt and Lightning Strike")
    println("==============||===||==============")

}

fun assignJob(choice : Int, p1 : Player ){
    if(choice == 1) {
        p1.jobName = "Warrior"
        p1.playerHealth = 300
        p1.ability1 = "Slash"
        p1.ability2 = "Crush"
        p1.ability1Dmg = 5
        p1.ability2Dmg = 10
    }
    else if (choice == 2) {
        p1.jobName = "Thief"
        p1.playerHealth = 150
        p1.ability1 = "Double-Cut"
        p1.ability2 = "Assassinate"
        p1.ability1Dmg = 15
        p1.ability2Dmg = 25
    }
    else if (choice == 3) {
        p1.jobName = "Archer"
        p1.playerHealth = 200
        p1.ability1 = "Arrow Shot"
        p1.ability2 = "Snipe"
        p1.ability1Dmg = 10
        p1.ability2Dmg = 20
    }
    else if (choice == 4) {
        p1.jobName = "Mage"
        p1.playerHealth = 100
        p1.ability1 = "Magic Bolt"
        p1.ability2 = "Lightning Strike"
        p1.ability1Dmg = 20
        p1.ability2Dmg = 35
    }
}


fun adventureBattle(p1 : Player){

    // List of Monsters and Locations
    val possLocations = listOf<String>("Ancient Temple", "Underground Cave", "Maze Dungeon", "Forest of Death")
    val atMonsters = listOf<String>("Stone Golem", "Lightning Golem", "Metal Golem","Rock Beetle")
    val ucMonsters = listOf<String>("Small Goblin", "Hobgoblin","Chief Goblin", "Goblin Archer")
    val mdMonsters = listOf<String>("Zombie", "Mummy", "Necromancer", "Ghost")
    val fdMonsters = listOf<String>("Poison Mushroom", "Feral Boar", "Giant Snake","Death Hornet")

    // Variables to Control Random Spawn of Monster and Location Choice
    val randomVal = nextInt(4)
    val randomMon = nextInt(4)

    // Variable to control adventuring loop
    var isAdventuring = true

    // Adventuring Loop begins
    while(isAdventuring) {

        // Variables for the Location and Monsters on this iteration of the Loop
        var locat = possLocations[randomVal]
        var newmonst = ""

        // When statement to control Certain Monsters Spawning in Locations
        when{
            locat == "Ancient Temple" -> newmonst = atMonsters[randomMon]
            locat == "Underground Cave" -> newmonst = ucMonsters[randomMon]
            locat == "Maze Dungeon" -> newmonst = mdMonsters[randomMon]
            locat == "Forest of Death" -> newmonst = fdMonsters[randomMon]
        }

        // Dialogue for Location and Monster Encounter
        println("You have decided to go off and adventure")
        println("As you follow one of the pathways out of town you find yourself at The $locat")
        println("When you go deeper into the area you run into a $newmonst")
        println("The $newmonst has noticed you and charges to fight!")
        println("")
        println("==============||===||==============")
        println("Are you ready for a fight?!")
        print("")
        println("TYPE THE NUMBER OF THE CORRESPONDING CHOICE")
        println("==============||===||==============")
        println("1. I was born for Adventure! Die Monster!")
        println("2. RUN AWAY")
        println("==============||===||==============")
        println("")

        var battleChoice = readLine()!!.toInt()

        // Conditional controlling Monster Encounter options
        if(battleChoice == 1){
            println("No one ever taught you how to use your abilities.")
            println("As you remember this fact, the $newmonst strikes your vitals.")
            println("You draw your last breath and a bright light envelops you.")
            println("")
            //isAdventuring = false

        }

        else if(battleChoice == 2){
            println("==============||===||==============")
            println("As you turn your back to run away, The $newmonst strikes at your vitals")
            println("You bleed out as the monster slowly approaches you")
            println("The last thing you see before closing your eyes is the $newmonst's jaws about to close on you")
            println("A bright light envelops you and you awaken in Town")
            println("==============||===||==============")
            println("")
            //isAdventuring = false
        }

        else{
            println("That was not an option. Try again")
        }
        isAdventuring = false

    }
}

fun game(p1 : Player){
    println("==============||===||==============")
    println("     What is your name, Hero?")
    println("==============||===||==============")

    p1.playerName = readLine().toString()

    println("==============||===||==============")
    println("That's a cool name you got, ${p1.playerName}")
    println("With a name like that you are ready to receive an adventurer job")
    println("Every adventurer has a job or fighting style")
    println("There are four basic jobs. Warrior, Thief, Archer, and Mage")
    println("You can select any job you want. However, it can't be changed afterwards")
    println("==============||===||==============")
    println()

    // Variable to control job choice loop
    var isChoosing = true

    // Loop for player while choosing job
    while(isChoosing){
        println("==============||===||==============")
        println("You can now choose a job")
        println("==============||===||==============")
        println()
        println("Type the number for one of the following choices to go forward")
        println()
        println("==============||===||==============")
        println("1. Show Job Descriptions")
        println("2. Select your Job")
        println("==============||===||==============")
        var choice = readLine()!!.toInt()

        if(choice == 1){
            displayJobInfo()
        }
        else if(choice == 2){
            println("==============||===||==============")
            println("Type the number of the corresponding Job")
            println("==============||===||==============")
            println("1. Warrior")
            println("==============||===||==============")
            println("2. Thief")
            println("==============||===||==============")
            println("3. Archer")
            println("==============||===||==============")
            println("4. Mage")
            println("==============||===||==============")
            println("")
            var numJChoice = readLine()!!.toInt()
            if(numJChoice in 1..4){
                assignJob(numJChoice,p1)
                isChoosing = false
            }
            else{
                println("That was not an option. Please enter another option")
                println("")
            }
        }
        else{
            println("That was not an option. Please enter another option")
            println("")
        }
    }

    // Player Name/Class/and ability introduction
    println("")
    println("==============||===||==============")
    println("So, you are ${p1.playerName} and you are a ${p1.jobName}")
    println("Your ${p1.jobName} abilities are ${p1.ability1} and ${p1.ability2}")
    println("Go Forth! Your Adventure Awaits!")
    println("==============||===||==============")
    println("")

    println("==============||===||==============")
    println("You are now free to roam the world of One!")
    println("-A bright light envelops you and when it dissipates you find yourself in a town-")
    println("==============||===||==============")
    println("")

    // Variable to control roaming town and the world Loop
    var isRoaming = true

    // Loop for roaming town and and the world
    while(isRoaming){
        println("==============||===||==============")
        println("You are in Town. While here your health is recovered")
        println("==============||===||==============")
        println("")

        println("==============||===||==============")
        println("What will you do now?")
        println("==============||===||==============")
        println("")
        println("TYPE THE NUMBER OF THE CORRESPONDING CHOICE")
        println("")
        println("==============||===||==============")
        println("1. Explore Town")
        println("2. Find an Inn and Rest")
        println("3. Go to the Local Tavern")
        println("4. Go on an Adventure!")
        println("5. Quit your Adventure and bring Everlasting Shame to Your Loved Ones")
        println("==============||===||==============")
        println("")

        var choiceInTown = readLine()!!.toInt()

        // Conditional Controlling options once in Town
        if(choiceInTown == 1){
            println("-You begin to take a walk around town-")
            println("There are streets filled with adventurers and tall buildings.")
            println("Restaurants, Equipment Shops, and Item Shops are all around")
            println("There are many water fountains and grassy areas where people gather")
            println("As you stop in those areas, you can see people displaying their Arts and Crafts")
            println("")
        }
        else if(choiceInTown == 2){
            println("-You walk around and stop at the nearest Inn-")
            println("Stopping at the front Desk, the Innkeeper hands you some keys with a number on it")
            println("Taking the stairs, you walk up to your room and get some rest")
            println("After hours of sleeping, you are ready for another day!")
        }
        else if(choiceInTown == 3){
            println("-You walk around and see a large crowd gathered inside a Tavern-")
            println("You stop inside and find Adventurers Gathered around sharing their stories")
            println("Before you know it, you are sucked into the stories and stay awhile")
            println("After being filled to the brim with laughter and drinks, everyone says their goodbyes")
            println("You exit the Tavern.")
            println("")
        }
        else if(choiceInTown == 4){

            adventureBattle(p1)

        }
        else if(choiceInTown == 5){
            println("You are a disgrace! No stories of glory or adventure will be told of you")
            println("The adventure ends here!")
            println("")
            isRoaming = false
        }
        else{
            println("That was not one of the options. Please Try again")
            println("")
        }

    }


}

fun main(args: Array<String>) {

    // Initialize player class
    val p1 = Player()

    // Initialize playing bool
    var playing = true

    // Loop that keeps the game going
    while(playing){
        // Welcome screen
        println("==============||===||==============")
        println("      Welcome to the Adventure")
        println("==============||===||==============")
        println()
        // Start Instructions
        println("Type START to begin and QUIT to end")
        var startInp = readLine()
        if(startInp!!.toUpperCase() == "START") {
            introDescription()
            game(p1)

        }
        else if(startInp!!.toUpperCase() == "QUIT") {
            println("Your adventure ends here")
            playing = false
        }
        else {
            println("Input not recognized. Try again")
        }
    }

}