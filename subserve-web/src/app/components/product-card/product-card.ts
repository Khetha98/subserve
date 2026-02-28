import { Component, Input } from '@angular/core';
import { ProductModel } from '../../interfaces/product.model';

@Component({
  selector: 'app-product-card',
  standalone: true,
  templateUrl: './product-card.html',
  styleUrl: './product-card.scss',
})
export class ProductCardComponent {
  @Input() product!: ProductModel;
}