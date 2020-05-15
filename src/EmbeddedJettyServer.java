import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class EmbeddedJettyServer 
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
 
        WebAppContext context = new WebAppContext();
        context.setDescriptor(context+"/WebContent/WEB-INF/web.xml");
        context.setResourceBase("./WebContent");
        context.setContextPath("/db2rca");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
 
        server.start();
        server.join();
    }
}
