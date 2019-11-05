/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abooo
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.TrayIcon.MessageType;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;
public class SFJobMain extends javax.swing.JFrame {

    /**
     * Creates new form SFJobMain
     */
    HashMap<String,ArrayList<JobNode>> Jobs ;
    String all_jobs[]={"it","healthcare","social","marketing","communication","media","other","operation","hotel",
          "graphicdesign","languages","account","engineering","education","art","business","law"};
    String cities[] = {"نابلس","بيت لحم","رام الله","قلقيليه","طولكرم","الخليل","اريحا","جنين","روابي","القدس","غزه"};
  HashMap<String,ArrayList<JobNode>> getRedis()
    {
    return Jobs;
    }


  void selectjob(JButton domainB,String dom)
  {

       DefaultTableModel model =(DefaultTableModel) resultT.getModel();
      ArrayList<JobNode> domain = Jobs.get(dom);
        System.out.println("HI THERE MATD" + domain.size() );
        for(JobNode job:domain){
            System.out.println(job.job_company );
            Object []o= {job.job_name,job.job_company,job.job_publish_date,job.job_location,job.job_link };
            model.addRow(o);
  }
  }
     void printTable(JButton domainB){
        DefaultTableModel model =(DefaultTableModel) resultT.getModel();

        HashMap<String,ArrayList<JobNode>> Jobs = getRedis();
        if(domainB == technology){
        selectjob(technology,all_jobs[0]);
        }
        else if(domainB==medicin)
        {
            selectjob(medicin,all_jobs[1]);
        }
        else if(domainB==humanS)
        {
            selectjob(humanS,all_jobs[2]);
        }
        else if(domainB==marketing)
        {
            selectjob(marketing,all_jobs[3]);
        }
        else if(domainB==publicR)
        {
            selectjob(publicR,all_jobs[4]);
        }
        else if(domainB==press)
        {
            selectjob(press,all_jobs[5]);
        }
        else if(domainB==otherD)
        {
            selectjob(otherD,all_jobs[6]);
        }
        else if(domainB==backup)
        {
            selectjob(backup,all_jobs[7]);
        }
        else if(domainB==hotel)
        {
            selectjob(hotel,all_jobs[8]);
        }
        else if(domainB==graphicD)
        {
            selectjob(graphicD,all_jobs[9]);
        }
        else if(domainB==language)
        {
            selectjob(language,all_jobs[10]);
        }
        else if(domainB==accounting)
        {
            selectjob(accounting,all_jobs[11]);
        }
        else if(domainB==engineering)
        {
            selectjob(engineering,all_jobs[12]);
        }
        else if(domainB==education)
        {
            selectjob(education,all_jobs[13]);
        }
        else if(domainB==culture)
        {
            selectjob(culture,all_jobs[14]);
        }
        else if(domainB==managment)
        {
            selectjob(managment,all_jobs[15]);
        }
        else if(domainB==law)
        {
            selectjob(law,all_jobs[16]);
        }
        
       // Object c[] = {"ali","sami","dani","kandi","aloha"};
        //.addRow(c);
         System.out.println("HI THERE MATD PPPP");



    }
    public SFJobMain() throws MalformedURLException,AWTException, IOException, FileNotFoundException, ScriptException {
        initComponents();
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //description.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
          ((JLabel) cityB.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
           //((JLabel) cityB.getRenderer()).setIcon(new ImageIcon(getClass().getResource("dome-of-the-rock (2).png")));
           resultT.getTableHeader().setFont(new Font("Plain", Font.ITALIC+Font.BOLD, 14));
           resultT.getTableHeader().setBackground(Color.WHITE);
         resultT.getTableHeader().setForeground(Color.decode("0x193460"));
           resultT.getTableHeader().setPreferredSize(new Dimension(30, 35));
           resultT.setRowHeight(50);
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)resultT.getDefaultRenderer(Object.class);
           renderer.setHorizontalAlignment(SwingConstants.TRAILING);
           renderer.setBackground(Color.LIGHT_GRAY);
           displayTray();
          // ImageIcon MI = new ImageIcon("C:\\Users\\abooo\\Desktop\\icon");
           this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("loupe.png")));
        //   phuman.setBorder(new CustomBorder());
        resultT.getColumnModel().getColumn(3).setPreferredWidth(resultT.getColumnModel().getColumn(3).getPreferredWidth()-100);
       RunPythonscript();
        //resultT.getColumnModel().getColumn(1).
       
      Jobs=  new RedisJava().getJobs();
          
          


        
     //   Home.setBackground(Color.GRAY);

    }
    void RunPythonscript() throws FileNotFoundException, ScriptException, IOException
    {
    
       
Process p = Runtime.getRuntime().exec("python.exe  D:/Programming/SoftwareEnginer/jobs.py") ;
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
String ret = new String(in.readLine());
System.out.println("value is : "+ret);
//Process p = Runtime.getRuntime().exec("python C:/Users/abooo/OneDrive/Documents/NetBeansProjects/SFJob/src/jobs.py");
    }
    int connectiontointernet()
    {

        try {
            URL url = new URL("https://www.google.ps/");
            URLConnection connection = url.openConnection();
            connection.connect();

            System.out.println("Connection Successful");
            return 1;
        }
        catch (Exception e) {
            System.out.println("Internet Not Connected");
            return 0;

        }

}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JobGroup = new javax.swing.ButtonGroup();
        container = new javax.swing.JPanel();
        headerc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        homeM = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Centercontainer = new javax.swing.JPanel();
        Main = new javax.swing.JPanel();
        phuman = new javax.swing.JPanel();
        humanS = new javax.swing.JButton();
        ptechnology = new javax.swing.JPanel();
        technology = new javax.swing.JButton();
        photel = new javax.swing.JPanel();
        hotel = new javax.swing.JButton();
        pPublicr = new javax.swing.JPanel();
        publicR = new javax.swing.JButton();
        Plaw = new javax.swing.JPanel();
        law = new javax.swing.JButton();
        peducation = new javax.swing.JPanel();
        education = new javax.swing.JButton();
        pengineer = new javax.swing.JPanel();
        engineering = new javax.swing.JButton();
        pcukture = new javax.swing.JPanel();
        culture = new javax.swing.JButton();
        pmarketing = new javax.swing.JPanel();
        marketing = new javax.swing.JButton();
        potherD = new javax.swing.JPanel();
        otherD = new javax.swing.JButton();
        pmanagment = new javax.swing.JPanel();
        managment = new javax.swing.JButton();
        pbackup = new javax.swing.JPanel();
        backup = new javax.swing.JButton();
        pmedicin = new javax.swing.JPanel();
        medicin = new javax.swing.JButton();
        paccouting = new javax.swing.JPanel();
        accounting = new javax.swing.JButton();
        pgraphic = new javax.swing.JPanel();
        graphicD = new javax.swing.JButton();
        planguage = new javax.swing.JPanel();
        language = new javax.swing.JButton();
        pempty = new javax.swing.JPanel();
        ppress = new javax.swing.JPanel();
        press = new javax.swing.JButton();
        Result = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        city = new javax.swing.JLabel();
        domain = new javax.swing.JLabel();
        cityB = new javax.swing.JComboBox<>();
        Connectstate = new javax.swing.JLabel();
        dateR = new javax.swing.JFormattedTextField();
        tablecontainer = new javax.swing.JPanel();
        jScrollPaneTable = new javax.swing.JScrollPane();
        resultT = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Discover Jobs");
        setAlwaysOnTop(true);
        setName("main"); // NOI18N
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new java.awt.CardLayout());

        container.setBackground(new java.awt.Color(233, 235, 238));

        headerc.setBackground(new java.awt.Color(38, 78, 144));

        jLabel1.setFont(new java.awt.Font("Tiranti Solid LET", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JOBS");

        homeM.setBackground(new java.awt.Color(38, 78, 144));
        homeM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        homeM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hous1e.png"))); // NOI18N
        homeM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 78, 144)));
        homeM.setRequestFocusEnabled(false);
        homeM.setVerifyInputWhenFocusTarget(false);
        homeM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/47178800_2206788536234076_288627480237965312_n.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/47133405_541197019683436_4963611193370476544_n.png"))); // NOI18N

        javax.swing.GroupLayout headercLayout = new javax.swing.GroupLayout(headerc);
        headerc.setLayout(headercLayout);
        headercLayout.setHorizontalGroup(
            headercLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headercLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeM, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(624, 624, 624)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(467, 467, 467)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(headercLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headercLayout.createSequentialGroup()
                    .addGap(0, 1561, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        headercLayout.setVerticalGroup(
            headercLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headercLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeM)
                .addGap(25, 25, 25))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
            .addGroup(headercLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
        );

        Centercontainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 78, 144), 10));
        Centercontainer.setLayout(new java.awt.CardLayout());

        Main.setToolTipText("اختر مجال للبحث به");
        Main.setAlignmentY(2.0F);
        Main.setName("مجالات البحث"); // NOI18N
        Main.setLayout(new java.awt.GridLayout(6, 3));

        phuman.setBackground(new java.awt.Color(233, 235, 238));

        humanS.setBackground(new java.awt.Color(255, 255, 255));
        humanS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        humanS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multiple-users-silhouette.png"))); // NOI18N
        humanS.setText("العلوم الانسانيه");
        humanS.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        humanS.setFocusCycleRoot(true);
        humanS.setMaximumSize(new java.awt.Dimension(203, 71));
        humanS.setMinimumSize(new java.awt.Dimension(203, 71));
        humanS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout phumanLayout = new javax.swing.GroupLayout(phuman);
        phuman.setLayout(phumanLayout);
        phumanLayout.setHorizontalGroup(
            phumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phumanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(humanS, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
        phumanLayout.setVerticalGroup(
            phumanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phumanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(humanS, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
        );

        Main.add(phuman);

        ptechnology.setBackground(new java.awt.Color(233, 235, 238));

        technology.setBackground(new java.awt.Color(255, 255, 255));
        technology.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        technology.setIcon(new javax.swing.ImageIcon(getClass().getResource("/binary-code.png"))); // NOI18N
        technology.setText("تكنولوجيا المعلومات");
        technology.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ptechnologyLayout = new javax.swing.GroupLayout(ptechnology);
        ptechnology.setLayout(ptechnologyLayout);
        ptechnologyLayout.setHorizontalGroup(
            ptechnologyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ptechnologyLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(technology, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        ptechnologyLayout.setVerticalGroup(
            ptechnologyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ptechnologyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(technology, javax.swing.GroupLayout.PREFERRED_SIZE, 71, Short.MAX_VALUE))
        );

        Main.add(ptechnology);

        photel.setBackground(new java.awt.Color(233, 235, 238));

        hotel.setBackground(new java.awt.Color(255, 255, 255));
        hotel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel.png"))); // NOI18N
        hotel.setText("الفندقه والسياحه");
        hotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout photelLayout = new javax.swing.GroupLayout(photel);
        photel.setLayout(photelLayout);
        photelLayout.setHorizontalGroup(
            photelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, photelLayout.createSequentialGroup()
                .addComponent(hotel, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        photelLayout.setVerticalGroup(
            photelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, photelLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(hotel))
        );

        Main.add(photel);

        pPublicr.setBackground(new java.awt.Color(233, 235, 238));

        publicR.setBackground(new java.awt.Color(255, 255, 255));
        publicR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        publicR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/connection.png"))); // NOI18N
        publicR.setText("العلاقات العامه والاتصال");
        publicR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPublicrLayout = new javax.swing.GroupLayout(pPublicr);
        pPublicr.setLayout(pPublicrLayout);
        pPublicrLayout.setHorizontalGroup(
            pPublicrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPublicrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(publicR, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
        pPublicrLayout.setVerticalGroup(
            pPublicrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPublicrLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(publicR, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(pPublicr);

        Plaw.setBackground(new java.awt.Color(233, 235, 238));

        law.setBackground(new java.awt.Color(255, 255, 255));
        law.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        law.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gavel.png"))); // NOI18N
        law.setText("القانون والمحاماة");
        law.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlawLayout = new javax.swing.GroupLayout(Plaw);
        Plaw.setLayout(PlawLayout);
        PlawLayout.setHorizontalGroup(
            PlawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlawLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(law, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        PlawLayout.setVerticalGroup(
            PlawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlawLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(law, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(Plaw);

        peducation.setBackground(new java.awt.Color(233, 235, 238));

        education.setBackground(new java.awt.Color(255, 255, 255));
        education.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        education.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graduation.png"))); // NOI18N
        education.setText("التعليم والتدريب");
        education.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                educationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout peducationLayout = new javax.swing.GroupLayout(peducation);
        peducation.setLayout(peducationLayout);
        peducationLayout.setHorizontalGroup(
            peducationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peducationLayout.createSequentialGroup()
                .addComponent(education, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        peducationLayout.setVerticalGroup(
            peducationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, peducationLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(education, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(peducation);

        pengineer.setBackground(new java.awt.Color(233, 235, 238));

        engineering.setBackground(new java.awt.Color(255, 255, 255));
        engineering.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        engineering.setIcon(new javax.swing.ImageIcon(getClass().getResource("/golden-gate.png"))); // NOI18N
        engineering.setText("الهندسه");
        engineering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engineeringActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pengineerLayout = new javax.swing.GroupLayout(pengineer);
        pengineer.setLayout(pengineerLayout);
        pengineerLayout.setHorizontalGroup(
            pengineerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengineerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(engineering, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
        pengineerLayout.setVerticalGroup(
            pengineerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengineerLayout.createSequentialGroup()
                .addComponent(engineering, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Main.add(pengineer);

        pcukture.setBackground(new java.awt.Color(233, 235, 238));

        culture.setBackground(new java.awt.Color(255, 255, 255));
        culture.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        culture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/porcelain.png"))); // NOI18N
        culture.setText("الثقافه والفنون");
        culture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cultureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pcuktureLayout = new javax.swing.GroupLayout(pcukture);
        pcukture.setLayout(pcuktureLayout);
        pcuktureLayout.setHorizontalGroup(
            pcuktureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcuktureLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(culture, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pcuktureLayout.setVerticalGroup(
            pcuktureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pcuktureLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(culture, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(pcukture);

        pmarketing.setBackground(new java.awt.Color(233, 235, 238));

        marketing.setBackground(new java.awt.Color(255, 255, 255));
        marketing.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        marketing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cart.png"))); // NOI18N
        marketing.setText("التسويق والمبيعات");
        marketing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marketingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pmarketingLayout = new javax.swing.GroupLayout(pmarketing);
        pmarketing.setLayout(pmarketingLayout);
        pmarketingLayout.setHorizontalGroup(
            pmarketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pmarketingLayout.createSequentialGroup()
                .addComponent(marketing, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        pmarketingLayout.setVerticalGroup(
            pmarketingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pmarketingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(marketing, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(pmarketing);

        potherD.setBackground(new java.awt.Color(233, 235, 238));

        otherD.setBackground(new java.awt.Color(255, 255, 255));
        otherD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        otherD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file.png"))); // NOI18N
        otherD.setText("مجالات متنوعه");
        otherD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout potherDLayout = new javax.swing.GroupLayout(potherD);
        potherD.setLayout(potherDLayout);
        potherDLayout.setHorizontalGroup(
            potherDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(potherDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(otherD, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
        potherDLayout.setVerticalGroup(
            potherDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, potherDLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(otherD, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(potherD);

        pmanagment.setBackground(new java.awt.Color(233, 235, 238));

        managment.setBackground(new java.awt.Color(255, 255, 255));
        managment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        managment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team.png"))); // NOI18N
        managment.setText("الاداره والاعمال");
        managment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pmanagmentLayout = new javax.swing.GroupLayout(pmanagment);
        pmanagment.setLayout(pmanagmentLayout);
        pmanagmentLayout.setHorizontalGroup(
            pmanagmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pmanagmentLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(managment, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pmanagmentLayout.setVerticalGroup(
            pmanagmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pmanagmentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(managment, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(pmanagment);

        pbackup.setBackground(new java.awt.Color(233, 235, 238));

        backup.setBackground(new java.awt.Color(255, 255, 255));
        backup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/call-center.png"))); // NOI18N
        backup.setText("العمليات والدعم اللوجستي");
        backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pbackupLayout = new javax.swing.GroupLayout(pbackup);
        pbackup.setLayout(pbackupLayout);
        pbackupLayout.setHorizontalGroup(
            pbackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbackupLayout.createSequentialGroup()
                .addComponent(backup, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        pbackupLayout.setVerticalGroup(
            pbackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        Main.add(pbackup);

        pmedicin.setBackground(new java.awt.Color(233, 235, 238));

        medicin.setBackground(new java.awt.Color(255, 255, 255));
        medicin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        medicin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/first-aid-kit.png"))); // NOI18N
        medicin.setText("الطب والتمريض والصحه");
        medicin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pmedicinLayout = new javax.swing.GroupLayout(pmedicin);
        pmedicin.setLayout(pmedicinLayout);
        pmedicinLayout.setHorizontalGroup(
            pmedicinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pmedicinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medicin, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
        pmedicinLayout.setVerticalGroup(
            pmedicinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(medicin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        Main.add(pmedicin);

        paccouting.setBackground(new java.awt.Color(233, 235, 238));

        accounting.setBackground(new java.awt.Color(255, 255, 255));
        accounting.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        accounting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank.png"))); // NOI18N
        accounting.setText("المحاسبه والعلوم الماليه");
        accounting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paccoutingLayout = new javax.swing.GroupLayout(paccouting);
        paccouting.setLayout(paccoutingLayout);
        paccoutingLayout.setHorizontalGroup(
            paccoutingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paccoutingLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(accounting, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        paccoutingLayout.setVerticalGroup(
            paccoutingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paccoutingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(accounting, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Main.add(paccouting);

        pgraphic.setBackground(new java.awt.Color(233, 235, 238));

        graphicD.setBackground(new java.awt.Color(255, 255, 255));
        graphicD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        graphicD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/color.png"))); // NOI18N
        graphicD.setText("تصميم وجراافيك");
        graphicD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphicDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pgraphicLayout = new javax.swing.GroupLayout(pgraphic);
        pgraphic.setLayout(pgraphicLayout);
        pgraphicLayout.setHorizontalGroup(
            pgraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pgraphicLayout.createSequentialGroup()
                .addComponent(graphicD, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        pgraphicLayout.setVerticalGroup(
            pgraphicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphicD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        );

        Main.add(pgraphic);

        planguage.setBackground(new java.awt.Color(233, 235, 238));

        language.setBackground(new java.awt.Color(255, 255, 255));
        language.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        language.setIcon(new javax.swing.ImageIcon(getClass().getResource("/translate.png"))); // NOI18N
        language.setText("اللغات والترجمه");
        language.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout planguageLayout = new javax.swing.GroupLayout(planguage);
        planguage.setLayout(planguageLayout);
        planguageLayout.setHorizontalGroup(
            planguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planguageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(language, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
        planguageLayout.setVerticalGroup(
            planguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planguageLayout.createSequentialGroup()
                .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        Main.add(planguage);

        pempty.setBackground(new java.awt.Color(233, 235, 238));

        javax.swing.GroupLayout pemptyLayout = new javax.swing.GroupLayout(pempty);
        pempty.setLayout(pemptyLayout);
        pemptyLayout.setHorizontalGroup(
            pemptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );
        pemptyLayout.setVerticalGroup(
            pemptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        Main.add(pempty);

        ppress.setBackground(new java.awt.Color(233, 235, 238));

        press.setBackground(new java.awt.Color(255, 255, 255));
        press.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        press.setIcon(new javax.swing.ImageIcon(getClass().getResource("/video-camera.png"))); // NOI18N
        press.setText("الصحافه والاعلام");
        press.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ppressLayout = new javax.swing.GroupLayout(ppress);
        ppress.setLayout(ppressLayout);
        ppressLayout.setHorizontalGroup(
            ppressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppressLayout.createSequentialGroup()
                .addComponent(press, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );
        ppressLayout.setVerticalGroup(
            ppressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ppressLayout.createSequentialGroup()
                .addComponent(press, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        Main.add(ppress);

        Centercontainer.add(Main, "card4");

        Result.setBackground(new java.awt.Color(247, 247, 247));
        Result.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 78, 144), 0));

        header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 78, 144), 5));

        city.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        city.setForeground(new java.awt.Color(55, 92, 153));
        city.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        city.setText("المدينه");

        domain.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        domain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        domain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "المجال", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(55, 92, 153))); // NOI18N
        domain.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        cityB.setBackground(new java.awt.Color(177, 202, 219));
        cityB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cityB.setForeground(new java.awt.Color(255, 255, 255));
        cityB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نابلس", "بيت لحم", "رام الله", "قلقيليه", "طولكرم", "الخليل", "اريحا", "جنين", "روابي", "القدس", "غزه" }));
        cityB.setToolTipText("اختر المدينه للبحث بها");
        cityB.setBorder(null);
        cityB.setLightWeightPopupEnabled(false);
        cityB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityBActionPerformed(evt);
            }
        });

        Connectstate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Connectstate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Connectstate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        Connectstate.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        dateR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "التاريخ", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(55, 92, 153))); // NOI18N
        dateR.setForeground(new java.awt.Color(25, 52, 96));
        dateR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(domain, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Connectstate, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 599, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(cityB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateR, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addComponent(domain, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Connectstate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tablecontainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 78, 144)));

        resultT.setBackground(new java.awt.Color(255, 102, 51));
        resultT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 78, 144)));
        resultT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resultT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "المسمى الوظيفي", "الشركه", "تاريخ النشر", "الموقع", "الرابط"
            }
        ));
        resultT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        resultT.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        resultT.setGridColor(new java.awt.Color(203, 219, 231));
        resultT.setSelectionBackground(new java.awt.Color(177, 202, 219));
        resultT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coulmnC(evt);
            }
        });
        jScrollPaneTable.setViewportView(resultT);
        if (resultT.getColumnModel().getColumnCount() > 0) {
            resultT.getColumnModel().getColumn(2).setMinWidth(100);
            resultT.getColumnModel().getColumn(2).setPreferredWidth(100);
            resultT.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        javax.swing.GroupLayout tablecontainerLayout = new javax.swing.GroupLayout(tablecontainer);
        tablecontainer.setLayout(tablecontainerLayout);
        tablecontainerLayout.setHorizontalGroup(
            tablecontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneTable)
        );
        tablecontainerLayout.setVerticalGroup(
            tablecontainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablecontainerLayout.createSequentialGroup()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(55, 92, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("لمزيد من المعلومات الرجاء الضغط على الرابط");

        javax.swing.GroupLayout ResultLayout = new javax.swing.GroupLayout(Result);
        Result.setLayout(ResultLayout);
        ResultLayout.setHorizontalGroup(
            ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablecontainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ResultLayout.setVerticalGroup(
            ResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tablecontainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Centercontainer.add(Result, "card3");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/47139462_1974209212885257_2099301218814787584_n.png"))); // NOI18N

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Centercontainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(headerc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Centercontainer, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(container, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void otherDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherDActionPerformed
  resultBlock(evt);
  domain.setIcon(new ImageIcon(getClass().getResource("file.png")));
  printTable(otherD);
    }//GEN-LAST:event_otherDActionPerformed

    private void homeMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMActionPerformed
    Main.setVisible(true);
     Result.setVisible(false);// TODO add your handling code here:
     cleartable();
    }//GEN-LAST:event_homeMActionPerformed
private  void open(URI uri) {
  if (Desktop.isDesktopSupported()) {
    try {
       Desktop.getDesktop().browse(uri);
      } catch (IOException e) { /* TODO: error handling */
          JOptionPane.showMessageDialog(null, "الرجاء الضغط على رابط صالح");
      }
   } else { System.out.println("browser does not supported"); }
 }
    void cleartable()
{
       DefaultTableModel dm = (DefaultTableModel)resultT.getModel();
int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    dm.removeRow(i);
}
}
    private void humanSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanSActionPerformed
            resultBlock(evt);
            domain.setIcon(new ImageIcon(getClass().getResource("multiple-users-silhouette.png")));
            printTable(humanS);
    }//GEN-LAST:event_humanSActionPerformed

    private void hotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotelActionPerformed
           resultBlock(evt);
           domain.setIcon(new ImageIcon(getClass().getResource("hotel.png")));
           printTable(hotel);
    }//GEN-LAST:event_hotelActionPerformed

    private void publicRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicRActionPerformed
       resultBlock(evt);
        domain.setIcon(new ImageIcon(getClass().getResource("connection.png")));
        printTable(publicR);
    }//GEN-LAST:event_publicRActionPerformed

    private void languageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageActionPerformed
  resultBlock(evt);
   domain.setIcon(new ImageIcon(getClass().getResource("translate.png")));
   printTable(language);
    }//GEN-LAST:event_languageActionPerformed

    private void graphicDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphicDActionPerformed
   resultBlock(evt);
    domain.setIcon(new ImageIcon(getClass().getResource("color.png")));
    printTable(graphicD);
    }//GEN-LAST:event_graphicDActionPerformed

    private void accountingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountingActionPerformed
  resultBlock(evt);
   domain.setIcon(new ImageIcon(getClass().getResource("bank.png")));
  printTable(accounting);
    }//GEN-LAST:event_accountingActionPerformed

    private void pressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressActionPerformed
   resultBlock(evt);
    domain.setIcon(new ImageIcon(getClass().getResource("video-camera.png")));
    printTable(press);
    }//GEN-LAST:event_pressActionPerformed

    private void cultureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cultureActionPerformed
  resultBlock(evt);
   domain.setIcon(new ImageIcon(getClass().getResource("porcelian.png")));
   printTable(culture);
    }//GEN-LAST:event_cultureActionPerformed

    private void medicinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicinActionPerformed
   resultBlock(evt);
    domain.setIcon(new ImageIcon(getClass().getResource("first-aid-kit.png")));
    printTable(medicin);
    }//GEN-LAST:event_medicinActionPerformed

    private void managmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managmentActionPerformed
   resultBlock(evt);
    domain.setIcon(new ImageIcon(getClass().getResource("team.png")));
    printTable(managment);
    }//GEN-LAST:event_managmentActionPerformed

    private void engineeringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engineeringActionPerformed
  resultBlock(evt);
   domain.setIcon(new ImageIcon(getClass().getResource("golden-gate.png")));
   printTable(engineering);
    }//GEN-LAST:event_engineeringActionPerformed

    private void backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupActionPerformed
  resultBlock(evt);
   domain.setIcon(new ImageIcon(getClass().getResource("call-center.png")));
   printTable(backup);
    }//GEN-LAST:event_backupActionPerformed

    private void educationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_educationActionPerformed
  resultBlock(evt);
   domain.setIcon(new ImageIcon(getClass().getResource("graduation.png")));
   printTable(education);
    }//GEN-LAST:event_educationActionPerformed

    private void lawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lawActionPerformed
  resultBlock(evt);
   domain.setIcon(new ImageIcon(getClass().getResource("gavel.png")));
   printTable(law);
    }//GEN-LAST:event_lawActionPerformed

    private void marketingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marketingActionPerformed
        resultBlock(evt);
        domain.setIcon(new ImageIcon(getClass().getResource("cart.png")));
        printTable(marketing);
    }//GEN-LAST:event_marketingActionPerformed

    private void dateRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateRActionPerformed
int citydomain()
{
    if(domain.getText().equals("تكنولوجيا المعلومات"))
    return 0;   
    else if(domain.getText().equals("الطب والتمريض والصحه"))
        return 1;
    else if(domain.getText().equals("العلوم الانسانيه"))
        return 2; 
    else if(domain.getText().equals("التسويق والمبيعات"))
        return 3;
     else if(domain.getText().equals("العلاقات العامه والاتصال"))
        return 4;
     else if(domain.getText().equals("العمليات والدعم اللوجستي"))
        return 7;
     else if(domain.getText().equals("الصحافه والاعلام"))
        return 5;
     else if(domain.getText().equals("مجالات متنوعه"))
        return 6;
     else if(domain.getText().equals("الفندقه والسياحه"))
        return 8;
     else if(domain.getText().equals("تصميم وجرافيك"))
        return 9; 
     else if(domain.getText().equals("اللغات والترجمه"))
        return 10; 
     else if(domain.getText().equals("المحاسبه والعلوم الماليه"))
        return 11; 
     else if(domain.getText().equals("الهندسه"))
        return 12; 
     else if(domain.getText().equals("التعليم والتدريب"))
        return 13;
     else if(domain.getText().equals("الثقافه والفنون"))
        return 14;
     else if(domain.getText().equals("الاداره والاعمال"))
        return 15;
     else if(domain.getText().equals("القانون والمحاماة"))
        return 16;

    else
         return -1;
}
    private void cityBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityBActionPerformed
     DefaultTableModel model = (DefaultTableModel)resultT.getModel();
   //  System.out.println(cityB.getItemAt(0));
      //  if( cityB.getSelectedItem().toString().matches("\\bنابلس\\b"))
    //  {
          cleartable();
          int index = citydomain();
          if(index!=-1)
          selectcity(index,cityB.getSelectedIndex(),model);


   //   }
        // TODO add your handling code here:
    }//GEN-LAST:event_cityBActionPerformed
    void selectcity(int indexjob,int indexcity, DefaultTableModel model)
    {
         ArrayList<JobNode> domain = Jobs.get(all_jobs[indexjob]);
        System.out.println("HI THERE MATD" + domain.size() );
        for(JobNode job:domain){
            if(job.job_location.contains(cities[indexcity])){
            System.out.println(job.job_company );
            Object []o= {job.job_name,job.job_company,job.job_publish_date,job.job_location,job.job_link };
            model.addRow(o);
            }
            else
            {
               // System.out.println("no");
                continue;
            }
      }
    }
    private void coulmnC(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coulmnC
    int row = resultT.getSelectedRow();
    int column = resultT.getSelectedColumn();
    String uri = resultT.getValueAt(row, column).toString();
    
    URI link ;
        try {
            if(column==4)
            {
              link = new URI(uri);
              open(link); 
            }
            else
            {
                return;
            }
             
        } catch (URISyntaxException ex) {
          JOptionPane.showMessageDialog(this, "الرجاء الضغط على رابط صالح", "تنبيه", 2);
        }

    }//GEN-LAST:event_coulmnC

    private void technologyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologyActionPerformed
        resultBlock(evt);
        domain.setIcon(new ImageIcon(getClass().getResource("binary-code.png")));
        printTable(technology);
    }//GEN-LAST:event_technologyActionPerformed
    public void resultBlock(ActionEvent evt)
    {
         Main.setVisible(false);
        dateR.setText(new Date().toString());
     Result.setVisible(true);// TODO add your handling code here:
     domain.setText(evt.getActionCommand());

     if(connectiontointernet()!=0)
     {
         Connectstate.setText("متصل بالانترنت");
         Icon x = new ImageIcon(getClass().getResource("tick.png"));
         Connectstate.setIcon(x);
     }
     else
     {
          Connectstate.setText("غير متصل بالانترنت");
         Icon x = new ImageIcon(getClass().getResource("unchecked.png"));
         Connectstate.setIcon(x);
     }

    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SFJobMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SFJobMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SFJobMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SFJobMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SFJobMain().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(SFJobMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AWTException ex) {
                    Logger.getLogger(SFJobMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SFJobMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ScriptException ex) {
                    Logger.getLogger(SFJobMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void displayTray()  {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("loupe.png"));
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Discover Jobs");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        try {
            tray.add(trayIcon);
        } catch (AWTException ex) {
            System.out.println("not added");
        }
       
        trayIcon.displayMessage("Discover Jobs Is running", "New Jobs", MessageType.INFO);
        trayIcon.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("loupe.png")));

        
    }
 
private Connection connection;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centercontainer;
    private javax.swing.JLabel Connectstate;
    private javax.swing.ButtonGroup JobGroup;
    private javax.swing.JPanel Main;
    private javax.swing.JPanel Plaw;
    private javax.swing.JPanel Result;
    private javax.swing.JButton accounting;
    private javax.swing.JButton backup;
    private javax.swing.JLabel city;
    private javax.swing.JComboBox<String> cityB;
    private javax.swing.JPanel container;
    private javax.swing.JButton culture;
    private javax.swing.JFormattedTextField dateR;
    private javax.swing.JLabel domain;
    private javax.swing.JButton education;
    private javax.swing.JButton engineering;
    private javax.swing.JButton graphicD;
    private javax.swing.JPanel header;
    private javax.swing.JPanel headerc;
    private javax.swing.JButton homeM;
    private javax.swing.JButton hotel;
    private javax.swing.JButton humanS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JButton language;
    private javax.swing.JButton law;
    private javax.swing.JButton managment;
    private javax.swing.JButton marketing;
    private javax.swing.JButton medicin;
    private javax.swing.JButton otherD;
    private javax.swing.JPanel pPublicr;
    private javax.swing.JPanel paccouting;
    private javax.swing.JPanel pbackup;
    private javax.swing.JPanel pcukture;
    private javax.swing.JPanel peducation;
    private javax.swing.JPanel pempty;
    private javax.swing.JPanel pengineer;
    private javax.swing.JPanel pgraphic;
    private javax.swing.JPanel photel;
    private javax.swing.JPanel phuman;
    private javax.swing.JPanel planguage;
    private javax.swing.JPanel pmanagment;
    private javax.swing.JPanel pmarketing;
    private javax.swing.JPanel pmedicin;
    private javax.swing.JPanel potherD;
    private javax.swing.JPanel ppress;
    private javax.swing.JButton press;
    private javax.swing.JPanel ptechnology;
    private javax.swing.JButton publicR;
    private javax.swing.JTable resultT;
    private javax.swing.JPanel tablecontainer;
    private javax.swing.JButton technology;
    // End of variables declaration//GEN-END:variables

 

}
