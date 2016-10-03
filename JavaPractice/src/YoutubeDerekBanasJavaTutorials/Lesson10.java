package YoutubeDerekBanasJavaTutorials;

import org.apache.commons.lang3.ArrayUtils;

/*
    Basic class definition
    public means this class can be used by other classes
    Class names should begin with a capital letter
    A file can't contain two public classes. It can contain classes that are not public
    If you place class files in the same folder the java compiler will be able to find them
 */

    /*
        The Goal of this tutorial is to make a game list this

        -----------------------------------------------------------------
    [0][0]  |*| |*| |*| |*| |*| |*| |*| |*| |*| |*|
            |*| |*| |*| |*| |*| |*| |*| |*| |*| |*|
            |*| |*| |*| |*| |*| |*| |*| |*| |*| |*|
            |*| |M| |F| |*| |*| |*| |*| |*| |*| |*|
            |*| |*| |*| |*| |*| |*| |*| |*| |*| |*|
            |*| |*| |*| |*| |*| |*| |*| |*| |*| |*|
            |*| |*| |*| |*| |*| |*| |*| |*| |*| |*|
            |P| |*| |*| |*| |*| |*| |*| |*| |*| |*|
            |*| |*| |*| |*| |D| |*| |*| |*| |*| |*|
            |*| |*| |*| |*| |*| |*| |*| |*| |*| |*|  [9][9]
     */

public class Lesson10 {
    public static void main(String[] args){

        MonsterTwo.buildBattleBoard();

        //ObjectName[] ArrayName = new ObjectName[number];
        MonsterTwo[] Monsters = new MonsterTwo[4];

        Monsters[0] = new MonsterTwo(1000, 20, 1, "Frank");
        Monsters[1] = new MonsterTwo(500, 40, 2, "Drac");
        Monsters[2] = new MonsterTwo(1000, 20, 1, "Paul");
        Monsters[3] = new MonsterTwo(1000, 20, 1, "George");

        MonsterTwo.redrawBoard();

        for(MonsterTwo monster : Monsters){
            if(monster.isAlive()) {
                int arrayItemIndex = ArrayUtils.indexOf(Monsters, monster);
                monster.moveMonster(Monsters, arrayItemIndex);
            }
        }
        MonsterTwo.redrawBoard();
    }
}
