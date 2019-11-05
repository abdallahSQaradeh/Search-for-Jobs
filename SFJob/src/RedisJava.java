

import java.util.ArrayList;
import java.util.HashMap;
import redis.clients.jedis.Jedis;

public class RedisJava {
    private HashMap<String,ArrayList<JobNode>> Jobs;
    private String[] list_names = {"it","healthcare","social","marketing","communication","media","other","operation","hotel",
          "graphicdesign","languages","account","engineering","education","art","business","law"};

   public RedisJava() {
       System.out.println("Connection to server sucessfully");
      //Connecting to Redis server on localhost
      Jobs = new HashMap();
      Jedis jedis = new Jedis("localhost");
      for(String str:list_names){
          ArrayList<JobNode> list = new ArrayList(500);
        String JobNamestr = "JobName" + str;
        String JobCompanystr = "JobCompany" + str;
        String JobLocationstr = "JobLocation" + str;
        String JobDatestr = "JobDate" + str;
        String JobLinkstr = "JobLink" + str;
        while( jedis.llen(JobNamestr) !=0){
            String job_name = jedis.rpop(JobNamestr);
            String job_company = jedis.rpop(JobCompanystr);
            String job_location = jedis.rpop(JobLocationstr);
            String job_publish_date = jedis.rpop(JobDatestr);
            String job_link = jedis.rpop(JobLinkstr);
            JobNode node = new JobNode(job_name,job_company,job_location,job_publish_date,job_link);
            list.add(node);
            System.out.println("hey ");
        }
        Jobs.put(str, list);
        System.out.println(str + " size : " + list.size());
      }
      //print();
      System.out.println("Connection to server sucessfully");
      //check whether server is running or not
      System.out.println("Server is running: "+jedis.ping());
   }
//   public void print(){
//       for(JobNode job:Jobs){
//        System.out.println("Job : " + job.job_name);
//        System.out.println("Company : " + job.job_company);
//        System.out.println("Job Location : " + job.job_location);
//        System.out.println("Job date : " + job.job_publish_date);
//        System.out.println("Job link : " + job.job_link);
//   }

   public HashMap<String,ArrayList<JobNode>> getJobs(){
       return Jobs;
   }
}


class JobNode{
    String job_name;
    String job_company;
    String job_location;
    String job_publish_date;
    String job_link;
    public JobNode(String job_name,String job_company,String job_location,String job_publish_date ,String job_link){
        this.job_name = job_name;
        this.job_company = job_company;
        this.job_location = job_location;
        this.job_publish_date = job_publish_date;
        this.job_link = job_link;
    }
}