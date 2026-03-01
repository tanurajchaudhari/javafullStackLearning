import { ApplicationConfig, importProvidersFrom, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { provideRouter, withRouterConfig } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { authInterceptorProviders } from './service/auth.interceptor';

import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { NgxUiLoaderModule, NgxUiLoaderConfig, NgxUiLoaderHttpModule } from 'ngx-ui-loader';

const ngxUiLoaderConfig: NgxUiLoaderConfig = {
  fgsType: 'circle',
  fgsColor: '#ff4081',
  text:"Please wait...",
  textColor:'#ff4081',
  pbColor:'#ff4081',
   pbThickness: 6,
  hasProgressBar: true,
  overlayColor: 'rgba(0,0,0,0.5)',

};

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    provideHttpClient(withInterceptorsFromDi()),
    provideZoneChangeDetection({ eventCoalescing: true }),
    importProvidersFrom(
      NgxUiLoaderModule.forRoot(ngxUiLoaderConfig),
      NgxUiLoaderHttpModule.forRoot({showForeground:true}),
    ),
    
    // provideAnimationsAsync(),
    authInterceptorProviders,
    // provideRouter(
    //   routes,
    //   withRouterConfig({
    //     onSameUrlNavigation: 'reload'
    //   })
    // ),


  ]
};
