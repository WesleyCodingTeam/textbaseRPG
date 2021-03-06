package WesleyCodingTeam;

public class Story {
    public static void storyOfHeroInTheBeginning(){
        Program.dialogue("...........................");
        Program.dialogue("...........................");                                                                                                                            
        Program.narrationDialogue("You slowly open your eyes to see the forest");
        Program.narrationDialogue("Your body aches all over");
        Program.dialogue("Where am I?");
        Program.npcDialogue("You have finally awakened.");
        Program.narrationDialogue("You looked around for a voice, no one was there");
        Program.dialogue("Who is there? Back away!");
        Program.npcDialogue("I was once the hero of ....! but now I am but a voice in your head");
        Program.dialogue("... What?");
        Program.narrationDialogue("You start laughing at your own insanity");
        Program.npcDialogue("Don't you know who I am!");
        Program.dialogue("The hero died years ago and you're saying you're him?");
        Program.npcDialogue("Hmph. You don't believe me?");
        Program.dialogue("Why would the dead hero be talking to me?");
        Program.npcDialogue("You have been chosen as the new hero!");
        Program.dialogue("Me?! I'm just a villager!");
        Program.npcDialogue("Look at your status! You have the ability to Level Up!");
        MainCharacter.statPage();
        Program.dialogue("My job is... Hero!? I was just a villager a second ago!");
        Program.npcDialogue("Do you believe me now?");
        Program.dialogue("Not really, but a little bit.");
        Program.narrationDialogue("You get up, grab the wolf's body, wood, and stones while talking with the ghost of the old hero");
    }
    public static void guildStory(){
        Program.narrationDialogue("You spot the bubbly well-lit guild");
        Program.narrationDialogue("You hear the excited and drunk conversations between adventurers");
        Program.narrationDialogue("Carrying the heavy Great Wolf and raw materials, you limp towards the entrance. You burst through the doors");
        Program.npcDialogue("Woah! Somebody help that kid!");
        Program.narrationDialogue("People quickly gather around you and help you with your bounty");
        Program.npcDialogue("This is.. this is a Great Wolf! An B class monster!");
        Program.npcDialogue(MainCharacter.name +"!");
        Program.narrationDialogue("The friendly guildmaster quickly runs over to you");
        Program.npcDialogue(MainCharacter.name+"! Yer look like yer nearly dead!");
        Program.dialogue("Hahahah... I completed the quest...");
        Program.npcDialogue("What? Er... Right! Get this cookie! You are hurt!");
        Inventory.setInventoryItem(3001, 1);
    }
    public static void guildStory2(){
        Program.dialogue("Sir... What about the Great Wolf?");
        Program.npcDialogue("Er... Unfertunitly kid, we didn't have any requests fer that.");
        Program.narrationDialogue("The Guildmaster ponders for a short while");
        Program.dialogue(".  .  .  .  ");
        Program.narrationDialogue("The Guildmaster's face lits up");
        Program.npcDialogue("I've got an idear fer ya kid! How bout you sell the materials to the shop around 'ere!");
        Program.dialogue("Huh?");
        Program.npcDialogue("Try head to the shop!");
    }
    public static void shopTutorial(){
        Program.npcDialogue("Heya kid? It's pretty late right now isn't it?");
        Program.dialogue("Yea, I guess so?");
        Program.npcDialogue("Isn't yer sister sort of strict bout that?");
        Program.narrationDialogue("You slowly realize what the Guildmaster meant");
        Program.dialogue("Uh.. Sir.. Could I stay at the guild tonight?");
        Program.npcDialogue("It's only gonna get worse kid, go back fer today");
        Program.dialogue("Right... Have any plans Mr. Hero?");
        Program.narrationDialogue("The Old Hero give no reply");
        Program.dialogue("Right...");
        Program.narrationDialogue("You realize the only thing to do now is sneak into your home");
    }
    public static void conflictAtHome(){
        Program.narrationDialogue("You try to sneak into your house");
        Program.narrationDialogue("You Slowly Open the door");
        Program.narrationDialogue("BONK");
        Program.narrationDialogue("You smash onto the ground");
        Program.npcDialogue("What time do you think it is right now!");
        Program.dialogue("Uh..");
        Program.narrationDialogue("Your sister notices your blood-covered body");
        Program.npcDialogue("What happened to you!?");
        Program.dialogue("Haha.. just got into a fight...");
        Program.npcDialogue("Why didn't you use your healing potion?");
        Program.dialogue("Oh! Right!");
        Program.systemDialogue("Tip! Use inventory to use your potion!");
        Program.npcDialogue("Ha.. I'm just glad you're safe, better get to bed or you'll get another punch to the head");
        Program.dialogue("You decide to get to bed before you get lights knocked out");
    
    }
}