import { Component, Input } from '@angular/core';
import { ProductModel } from '../../interfaces/product.model';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-card',
  imports:[RouterModule, CommonModule],
  standalone: true,
  templateUrl: './product-card.html',
  styleUrl: './product-card.scss',
})
export class ProductCardComponent {
  @Input() product!: ProductModel;

}