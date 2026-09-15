// camel-k: language=groovy
// camel-k: config=configmap:my-config

from('timer:config?period=5000')
    .setBody().simple('${configmap:my-config/message}')
    .to('log:info')
