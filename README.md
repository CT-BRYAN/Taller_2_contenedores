# Simulador de Descuentos con Quarkus

## Preguntas de análisis

1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?

Inversión de Control (IoC): 
Se aplica en clases anotadas como Main, VentaService, Auditoria, DescuentoRegular y DescuentoVIP.   
Inyección de Dependencias (DI):
En la clase Main para inyectar VentaService, en la clase VentaService para inyectar los calculadores de descuento mediante atributos con @Named descuentoRegular y descuentoVIP y para inyectar Auditoria a través del constructor.  

2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?

Los Qualifiers sirven para distinguir entre múltiples implementaciones de una misma interfaz.
Son necesarios por que existen dos clases DescuentoRegular y DescuentoVIP que implementan la misma interfaz CalculadoraDescuento. Si se intentara inyectar CalculadoraDescuento sin un calificador, el contenedor de CDI no sabría cuál de las dos clases elegir, lo que generaría un error de ambigüedad AmbiguousResolutionException. Los calificadores permiten especificar exactamente qué implementación se requiere en cada punto de inyección.

3. ¿Cuál es la diferencia entre @ApplicationScoped y @Dependent?

@ApplicationScoped: Define un ámbito de aplicación. Solo existe una única instancia de la clase en toda la aplicación. Dicha instancia se crea la primera vez que se solicita y se comparte entre todos los puntos de inyección durante todo el tiempo de ejecución   
@Dependent: Es el ámbito por defecto. No gestiona una instancia compartida; en su lugar, se crea una nueva instancia por cada punto de inyección, y su ciclo de vida está estrictamente ligado al objeto que lo contiene

4. ¿Por qué las instancias @ApplicationScoped pueden reutilizarse entre varias ventas?

Porque el contenedor ArC mantiene una referencia única para la aplicación completa. Al ser un objeto stateless sin estado mutable por venta, las invocaciones concurrentes o secuenciales a descuentoRegular y descuentoVIP reutilizan exactamente la misma instancia en memoria, reduciendo el consumo de recursos.


5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de CalculadoraDescuento?

Si se elimina el calificador en uno de los atributos inyectados de VentaService, el contenedor CDI detectará que hay múltiples clases que implementan la interfaz CalculadoraDescuento sin saber cuál inyectar. Como consecuencia, Quarkus arrojará una excepción de resolución ambigua AmbiguousResolutionException al iniciar la aplicación y esta no podrá compilar o arrancar correctamente.

