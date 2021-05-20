package ru.training.at.hw5;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"},
                glue = {"ru.training.at.hw5.hooks"})
public class RunnnerForCucumberTests  extends AbstractTestNGCucumberTests {
}
