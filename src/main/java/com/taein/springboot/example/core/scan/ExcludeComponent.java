//Dummy file for testing component scan.
package com.taein.springboot.example.core.scan;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcludeComponent {
    
}
