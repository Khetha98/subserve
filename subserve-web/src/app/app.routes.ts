import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { CartComponent } from './pages/cart/cart';
import { CheckoutComponent } from './pages/checkout/checkout';
import { DeliveryComponent } from './pages/delivery/delivery';
import { Login } from './pages/login/login';
import { Register } from './pages/register/register';
import { VasServices } from './pages/vas-services/vas-services';
import { About } from './pages/about/about';
import { Contact } from './pages/contact/contact';
import { Profile } from './pages/profile/profile';
import { ProductDetail } from './pages/product-detail/product-detail';
import { ProductComponent } from './pages/product/product';
import { Orders } from './pages/orders/orders';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductComponent },
  { path: 'product/:id', component: ProductDetail },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'delivery-areas', component: DeliveryComponent },
  {path:'login',component:Login},
  {path:'register', component:Register},
  {path:'services', component:VasServices},
  {path:'about',component:About},
  {path:'contact',component:Contact},
  {path:'profile', component:Profile},
  {path:'orders', component:Orders}
];

