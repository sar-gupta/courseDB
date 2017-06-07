import com.example.core.Course;
import com.example.core.Student;
import com.example.dao.CourseDAO;
import com.example.dao.StudentDAO;
import com.example.resources.CourseResources;
import com.example.resources.StudentResources;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AppApplication extends Application<AppConfiguration> {

    public static final Logger LOGGER = LoggerFactory.getLogger(AppApplication.class);

    public static void main(final String[] args) throws Exception {
        new AppApplication().run(args);
    }

    private final HibernateBundle<AppConfiguration> hibernate = new HibernateBundle<AppConfiguration>(Student.class,Course.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };


    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(new MigrationsBundle<AppConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }




    @Override
    public void run(final AppConfiguration configuration, final Environment environment)
            throws Exception {

//        final FacebookDao dao = new FacebookDao(hibernate.getSessionFactory());
//        environment.jersey().register(new FacebookResource(dao));
            final StudentDAO studentDAO = new StudentDAO(hibernate.getSessionFactory());
            final CourseDAO courseDAO = new CourseDAO(hibernate.getSessionFactory());


        environment.jersey().register(new StudentResources(studentDAO));
        environment.jersey().register(new CourseResources(courseDAO,studentDAO));


        LOGGER.info("Application name: {}", configuration.getAppName());
    }
}






