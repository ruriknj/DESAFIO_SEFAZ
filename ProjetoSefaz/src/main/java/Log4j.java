import org.apache.log4j.Logger;


public class Log4j {
	
		private static final Logger logger = Logger.getLogger( Log4j.class );

		public static void main( String[] args )
		{
			logger.debug( "debug test" );
			logger.info( "info test" );
			logger.warn( "warn test" );
			logger.error( "error test" );
		}
	}


