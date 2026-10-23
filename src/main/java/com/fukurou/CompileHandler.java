package com.fukurou;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import bluej.extensions2.event.CompileEvent;
import bluej.extensions2.event.CompileListener;

public class CompileHandler implements CompileListener{
    
    LocalTime startTime; 
    long timeTaken;

    @Override 
    public void compileStarted(CompileEvent event){
        startTime = LocalTime.now();

        System.out.println("Compile started at time: " + startTime);
    }

    @Override 
    public void compileSucceeded(CompileEvent event){
        timeTaken = timeBetween(startTime);

        System.out.println("Compile Succeeded in " + timeTaken + "s");
    }

    @Override 
    public void compileFailed(CompileEvent event){
        timeTaken = timeBetween(startTime);

        System.out.println("Compile Failed in " + timeTaken + "s");
    }

    @Override 
    public void compileError(CompileEvent event){
        System.out.println("Compile Error on Line: " + event.getErrorLineNumber());
    }

    @Override
    public void compileWarning(CompileEvent event){
        System.out.println("Compile Warnings Were Found: " + event.toString());
    }

    private long timeBetween(LocalTime start){
        LocalTime end = LocalTime.now();
        return ChronoUnit.SECONDS.between(start, end);
    }
}
