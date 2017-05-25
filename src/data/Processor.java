/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * @author root
 */
public class Processor {    

    protected String fileName;
    protected String path;
    protected File file;
    
    protected int step;
    
    protected double[][] bests;
    protected double[][] avgs;
    protected double[][] worsts;
    protected double[][] results;
    
    protected double[] bests_avg;
    protected double[] avgs_avg;
    protected double[] worsts_avg;
    protected double[] bests_sd;
    protected double[] avgs_sd;
    protected double[] worsts_sd;
    
    

    public Processor(double[][] bests, double[][] avgs, double[][] worsts, double[][] results) {
        this.bests = bests;
        this.avgs = avgs;
        this.worsts = worsts;
        this.results = results;
        path=System.getProperty("user.dir");
        fileName="output";      
        this.avgs_avg = new double[avgs.length];
        this.avgs_sd = new double[avgs.length];
        this.bests_avg= new double[bests.length];
        this.bests_sd= new double[bests.length];
        this.worsts_avg= new double[worsts.length];
        this.worsts_sd= new double[worsts.length];
        step=0;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }    
    
    public void toFile() throws FileNotFoundException, UnsupportedEncodingException{     
        
        file=new File(path+File.separator+fileName);       

        
        PrintWriter writer = new PrintWriter(file, "UTF-8");
        
        writer.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n","i",
                                                 "Best",
                                                 "Average",
                                                 "Worst",
                                                 "Best SD",
                                                 "Average SD",
                                                 "Worst SD");
  
        
        for (int i = 0; i < bests.length; i++) {
            writer.printf("%d\t%.15f\t%.15f\t%.15f\t%.15f\t%.15f\t%.15f\t\n", (i+1)*step
                                                                          , bests_avg[i]
                                                                          , avgs_avg[i]
                                                                          , worsts_avg[i]
                                                                          , bests_sd[i]
                                                                          , avgs_sd[i]
                                                                          , worsts_sd[i]);
        }
        
        writer.println("Results:");

        for (int i = 0; i < results.length; i++) {
            writer.println(Arrays.toString(results[i]));
        }

        writer.flush();
        writer.close();

    }
    
    public void process(){
        
        for (int i = 0; i < bests.length; i++) {
            
            for (double best : bests[i]) {
                bests_avg[i]+=best;                
            }            
            bests_avg[i]/=bests[i].length; 

            for (double best : bests[i]) {
                bests_sd[i]+=(best-bests_avg[i])*(best-bests_avg[i]);                
            }     

            bests_sd[i]/=bests[i].length-1; 

            bests_sd[i]=Math.sqrt(bests_sd[i]);           

        }

        for (int i = 0; i < avgs.length; i++) {

            for (double best : avgs[i]) {
                avgs_avg[i]+=best;                
            }            
            avgs_avg[i]/=avgs[i].length; 

            for (double best : avgs[i]) {
                avgs_sd[i]+=(best-avgs_avg[i])*(best-avgs_avg[i]);                
            }     

            avgs_sd[i]/=avgs[i].length-1; 

            avgs_sd[i]=Math.sqrt(avgs_sd[i]);           

        }

        for (int i = 0; i < worsts.length; i++) {

            for (double best : worsts[i]) {
                worsts_avg[i]+=best;                
            }            
            worsts_avg[i]/=worsts[i].length; 

            for (double best : worsts[i]) {
                worsts_sd[i]+=(best-worsts_avg[i])*(best-worsts_avg[i]);                
            }     

            worsts_sd[i]/=worsts[i].length-1; 

            worsts_sd[i]=Math.sqrt(worsts_sd[i]);           

        }

        
        
    }
    
    

    
}
