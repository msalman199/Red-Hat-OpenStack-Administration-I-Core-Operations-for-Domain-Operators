// camel-k: language=groovy

from('timer:scaling?period=1000')
    .setBody().constant('Testing auto-scaling')
    .to('log:info'

// camel-k: language=groovy
// camel-k: trait=health.enabled=true

from('timer:health?period=1000')
    .routeId('health-route')
    .setBody().constant('Health check test')
    .to('log:info')
