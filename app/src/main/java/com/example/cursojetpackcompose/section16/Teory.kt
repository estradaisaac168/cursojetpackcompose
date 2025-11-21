package com.example.cursojetpackcompose.section16

/**
 * NAVIGATION COMPONENT
 *
 * ¿Qué resuelve Navigation Component?
 *
 * Maneja el backstack (historial de pantallas) automaticamente
 * Permite pasar argumentos entre pantallas
 * Se integra con el ciclo de vida y el boton "Atras" de Android
 * Facilita animaciones, navegacion anidada y deep links
 * No se usa XML, es por eso que se hace de forma declarativa
 *
 * ¿Qué componentes se usan?
 *
 * NavController: Se encarga de navegar entre pantallas
 * NavHost: El contenedor en donde se renderizan las pantallas
 * Composable: Define una pantalla como una ruta
 * rememberNavController(): Recuerda el controlador de navegacion dentro de Compose
 *
 *
 * ¿Qué es el stack de navegación?
 *
 * Es una estructura de datos que se comporta como una pila de platos: el ultimo que se apila es el primero que se retira
 * a esto se le conoce como LIFO (El ultimo en entrar es el primero en salir)
 *
 *¿Por qué es util el Stack?
 *
 * Porque así podemos controlar facilmente:
 * La navegación hacia atrás
 * Cuantas pantallas hay en la historia
 * Cuándo cerrar rutas intermedias
 *
 *
 * PROPIEDADES
 *
 * navigate(route: String) -> Navega hacia la ruta especifica y puede incluir argumentos para el destino.
 *
 * popBackStack() -> Elimina la ultima ruta del stack.
 *
 * popBackStack(route: String, inclusive: Boolean) -> Elimina la ruta especifica del stack, si [inclusive] es true.
 *
 * currentDestination -> Representa el destino actual, útil para saber en que pantalla se encuentra el usuario.
 *
 * currentBackStackEntry -> Proporciona acceso a los argumentos y al estado del destino actual.
 *
 * previousBackStackEntry -> Similar al anterior, pero para el destino anterior en el Stack.
 *
 * addOnDestinationChangedListener -> Escucha cambios de destino en la navegacion. Util para registrar eventos
 * de analitica o actualizar dinamicamente la interfaz.
 *
 */