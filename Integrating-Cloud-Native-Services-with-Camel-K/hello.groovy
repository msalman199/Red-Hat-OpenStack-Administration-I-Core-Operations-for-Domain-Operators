// camel-k: language=groovy

from('timer:hello?period=3000')
    .setBody().constant('Hello from Camel K!')
    .to('log:info')
