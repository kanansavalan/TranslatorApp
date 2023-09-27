package managmentService;

import service.FileServiceInter;
import service.GameServiceInter;
import service.impl.FileServiceImpl;
import service.impl.GameServiceImpl;
import util.Print;

public class ManagmentService {



        public static void managment(){
            GameServiceInter gameServiceInter = new GameServiceImpl();
            while (true){
          int option =  Print.printMenu();

          switch (option){
              case 1:
                  gameServiceInter.start2();
                  break;
              case 2:
                  gameServiceInter.addWord();
                  break;
              case 3:
                  gameServiceInter.seeHistory();
                  break;
              case 0:
                  gameServiceInter.exit();
                  break;
              default:
                  System.out.println("Incorrect option");



          }


            }
        }
    }

