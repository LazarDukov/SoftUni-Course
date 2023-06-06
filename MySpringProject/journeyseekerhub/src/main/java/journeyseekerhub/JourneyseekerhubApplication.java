package journeyseekerhub;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JourneyseekerhubApplication {

    public static void main(String[] args) throws LifecycleException {
        SpringApplication.run(JourneyseekerhubApplication.class, args);
        Tomcat tomcat = new Tomcat();
    }

}
