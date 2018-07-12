package pl.marcelbaumgardt.naukasql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.marcelbaumgardt.naukasql.model.User;
import pl.marcelbaumgardt.naukasql.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Nauka_SQL {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Nauka_SQL.class, args);
        //UserDao userDao = context.getBean(UserDao.class);
        UserRepository userRepository = context.getBean(UserRepository.class);

        List<User> users=new ArrayList<>();
        users.add(new User("Acosmo123","0marcelidt1994@gmail.com",8));
        users.add(new User("cosmo123","1marcelidt1994@gmail.com",52));
        users.add(new User("Acosmo123","2marcelidt1994@gmail.com",100));
        users.add(new User("cosmo123","3marcelidt1994@gmail.com",20));
        users.forEach(userRepository::save);

        User firstUser = userRepository.findFirstByUsername("Acosmo123");
        System.out.println(firstUser);
        //User firstUser = userRepository.;//pobieramy pierwszy
        userRepository.deleteById(1L); //usuwamy go
        //pobieramy i wyświetlamy pozostałe
        userRepository.findAll().forEach(System.out::println);
context.close();


        /*
        users = userDao.customGetQquery("SELECT u FROM User u WHERE u.age>50");
        System.out.println(users);
        userDao.customDeleteQquery("DELETE  FROM User u WHERE u.username LIKE 'A%'");
        //users=userDao.customGetQquery("SELECT u FROM User u");
        System.out.println(users);
        userDao.customDeleteQquery("DELETE FROM User u WHERE u.age>50");
        users=userDao.customGetQquery("SELECT u FROM User u ORDER BY u.username");
        System.out.println(users);
        users=userDao.customGetQquery("SELECT u FROM User u WHERE email='12marcelidt1994@gmail.com' OR email='13marcelidt1994@gmail.com'");
        System.out.println(users);
        context.close();
        */
    }

    //Optional / Relacje / Refleksje -> dwoiedziec sie mniej wiecej co to
    //Dodac kilu userow i przetestowac wszytskie metpdy ktore stworzylismy,
    // customGet- pobierzemy wszystkich uesrow ktorych imie zaczyna sie na literke A lub sa starci o 20lat < 4 warianty>

    //html css - podstawowe tagi, formularz
}
