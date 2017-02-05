package com.gumtree.adsdemo.ads.viewmodel;

import com.gumtree.adsdemo.ui.services.NavigationService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class MainViewModelTest {
    @Mock
    NavigationService navigationService;
    MainViewModel mainViewModel ;
    @Before
    public void setUp() throws Exception{
        mainViewModel = new MainViewModel(navigationService);
    }
    @Test
    public void test_gotoDetailsCommand_Invokes_NavigationService() throws Exception {
        mainViewModel.gotoDetailsCommand(anyString());

        verify(navigationService).gotoDetails(anyString());
    }
}