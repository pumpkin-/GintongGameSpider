package SpiderUtils;

/**
 * Created by 123 on 2017/2/23.
 */
public class SpiderGameData {
    public static void main(String [] args){
        try {



            CommonSpiderKnowledge.ergodicUrl("spiderZOL", 0, "no");

             //跑完
          //  CommonSpiderKnowledge.ergodicUrl("spider52PKRW", 0, "no");
//
//           CommonSpiderKnowledge.ergodicUrl("spider52PKQQ", 0, "no");
//            Thread t1=new Thread(){
//                @Override
//                public void run() {
//                    try {
                          //有null 需要模版｜｜
//                        CommonSpiderKnowledge.ergodicUrl("spider52PKDL", 0, "no");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
          Thread t2=new Thread(){
               @Override
               public void run() {
                    try {
                        CommonSpiderKnowledge.ergodicUrl("spider52PKCY", 158, "no");
                    } catch (Exception e) {
                        e.printStackTrace();
                   }
                }
            };
//           t1.start();
            t2.start();
           // CommonSpiderKnowledge.ergodicUrl("spiderYXC", 0, "no");















        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
