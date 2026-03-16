import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { ProductComponent } from './pages/products/products';
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

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductComponent },
  { path: 'product/:id', component: ProductDetail },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'delivery-areas', component: DeliveryComponent },
  {path:'login',component:Login},
  {path:'register', component:Register},
  {path:'products', component:ProductComponent},
  {path:'services', component:VasServices},
  {path:'about',component:About},
  {path:'contact',component:Contact},
  {path:'profile', component:Profile},
];
