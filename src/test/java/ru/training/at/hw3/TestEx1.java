package ru.training.at.hw3;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestEx1 extends BaseTest{

    SoftAssert softAssert;
//    ServiceDifferentElementPage differentElementPage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        softAssert = new SoftAssert();
    }

    @Test
    public void ex1() {

        //Создали объект класса ХоумСтраница
        homePage = new HomePage(driver);
        //Вызвали метод Открыть сайт. Сайт открывается на этой странице.
        //Терь надо найти хедер и залогиниться
        homePage.openSite();

        //Сайт открыли, теперь нужно залогиниться
        homePage.performLogin(login, password);

        //теперь нужно получить имя юзера и узнать, что это нужное имя
        //залогиненого юзера взяли из метода, берущего текст из ячейки на странице
        //ожидаемый результат берем из родительского класса, куда берем из др класса
        String loggedUserName = homePage.getLoggedUserName();
        softAssert.assertEquals(loggedUserName, expectedUserName);


    }



}
