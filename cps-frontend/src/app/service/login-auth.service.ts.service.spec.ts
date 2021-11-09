import { TestBed } from '@angular/core/testing';
import { LoginAuthService } from './login-auth.service.ts.service';



describe('LoginAuth.Service.TsService', () => {
  let service: LoginAuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginAuthService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
