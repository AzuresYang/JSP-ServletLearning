package utils;

import java.io.*;
import utils.TimeUtils;
import utils.CurrentLineInfo;
import java.util.concurrent.TimeUnit;
/**
 * Created by 28029 on 2017/9/18.
 */
public class WLoger {
   private static final String deafaultLogerFileName = "loger.txt";
   private static final String warningLogerFileName = "warnningLoger.txt";
   private static final String errorLogerFileName = "errorLoger.txt";

   private static final File deafaultLogerFile = new File(deafaultLogerFileName);
   private static final File warningLogerFile = new File(warningLogerFileName);
   private static final File errorLogerFile = new File(errorLogerFileName);

   private static Object syncDefObj = new Object();
   private static Object syncWarObj = new Object();
   private static Object syncErrObj = new Object();

   private static final WLoger loger = new WLoger();
   //如Loger文件不存在，创建之
   static {
       try{
           if(!deafaultLogerFile.exists())
               deafaultLogerFile.createNewFile();
           if(!warningLogerFile.exists())
               warningLogerFile.createNewFile();
           if(!errorLogerFile.exists())
               errorLogerFile.createNewFile();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
   private WLoger(){

   }

   public static WLoger getInstance(){
       return loger;
   }

   public void loger(String str){
       synchronized (syncDefObj){
           if(!deafaultLogerFile.exists())
               try {
                   deafaultLogerFile.createNewFile();
               } catch (IOException e) {
                   e.printStackTrace();
               }

           write(deafaultLogerFile, str);
       }
   }

   public  void warnningLoger(String str){
        synchronized (syncWarObj){
            write(warningLogerFile, str);
        }
   }

   public  void errorLoger(String str){
        synchronized (syncErrObj){
            write(errorLogerFile, str);
        }
   }

    private  void write(File file, String str){
        try {
            FileWriter fw = new FileWriter(file,true);
            str +="\n"+getCallInfo()+"\n";
            fw.write(str);
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   private static String getCallInfo(){
       int  originStackIndex = 2;
       String info = "";
       info += "FileName:"+Thread.currentThread().getStackTrace()[originStackIndex].getFileName();
       info +="---ClassName:"+Thread.currentThread().getStackTrace()[originStackIndex].getClassName();
       info +="\nMethod:"+Thread.currentThread().getStackTrace()[originStackIndex].getMethodName();
       info +="---Line:"+Thread.currentThread().getStackTrace()[originStackIndex].getLineNumber()+"\n";
       info += TimeUtils.getCurrentTime()+"\n";
       return info;
   }
}
