// camel-k: language=groovy
// camel-k: config=secret:my-secret

from('timer:secret?period=10000')
    .setBody().simple('Password is ${secret:my-secret/password}')
    .to('log:info')
