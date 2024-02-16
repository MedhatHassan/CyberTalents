import base64
var = """Vm0wd2QyUXlVWGxWV0d4V1YwZDRWMVl3WkRSV01WbDNXa1JTVjAxV2JETlhhMUpUVmpBeFYySkVUbGhoTVVwVVZtcEJlRll5U2tWVWJHaG9UVlZ3VlZadGNFSmxSbGw1VTJ0V1ZXSkhhRzlVVmxaM1ZsWmFkR05GU214U2JHdzFWVEowVjFaWFNraGhSemxWVm14YU0xWnNXbUZrUjA1R1UyMTRVMkpIZHpGV1ZFb3dWakZhV0ZOcmFHaFNlbXhXVm0xNFlVMHhXbk5YYlVaclVqQTFSMVV5TVRSVk1rcElaSHBHVjFaRmIzZFdha1poVjBaT2NtRkhhRk5sYlhoWFZtMHhORmxWTUhoWGJrNVlZbFZhY2xWcVFURlNNVlY1VFZSU1ZrMXJjRWxhU0hCSFZqRmFSbUl6WkZkaGExcG9WakJhVDJOdFJraGhSazVzWWxob1dGWnRNSGhPUm14V1RVaG9XR0pyTlZsWmJGWmhZMnhXY1ZGVVJsTk5WbFkxVkZaU1UxWnJNWEpqUld4aFUwaENTRlpxUm1GU2JVbDZXa1prYUdFeGNHOVdha0poVkRKT2RGSnJhR2hTYXpWeldXeG9iMWRHV25STlNHaFBVbTE0VjFSVmFHOVhSMHB5VGxac1dtSkdXbWhaTVZwaFpFZFNTRkpyTlZOaVJtOTNWMnhXWVZReFdsaFRiRnBxVWxkU1lWUlZXbUZOTVZweFUydDBWMVpyY0ZwWGExcDNWakZLVjJOSWJGZFdSVXBvVmtSS1QyTXlUa1poUjNCVFlrVndWVlp0ZUc5Uk1XUnpWMWhvV0dKRk5WUlVWM2hIVGxaV2RHUkhkR2hpUlhBd1ZsZDRjMWR0U2tkWGJXaGFUVzVvV0ZsNlJsZGpiSEJIV2tkc1UySnJTbUZXTW5oWFdWWlJlRmRzYUZSaVJuQlpWbXRXZDFZeGJISlhhM1JVVW14d2VGVXlkR0ZpUmxwelYyeHdXR0V4Y0ROWmEyUkdaV3hHY21KR2FGaFRSVXBKVm10U1MxVXhXWGhYYmxaV1lsZG9WRmxZY0ZkbGJHUllaVWM1YVUxWFVraFdNalZUVkd4T1NGVnVUbFpoYTBwNlZHdGFWbVZYVWtoa1JtaFRUVWhDU2xac1pEUmpNV1IwVTJ0b2FGSnNTbGhVVlZwM1ZrWmFjVk5yWkZOaVJrcDZWa2N4YzFVeVNuSlRiVVpYVFc1b1dGZFdXbEpsUm1SellVWlNhVkp1UWxwV2JYUlhaREZaZUdKSVNsaGhNMUpVVlcxNGQyVkdWbGRoUnpsb1RWWndlbFl5Y0VkV01ERjFZVWRvV2xaWFVrZGFWV1JQVWpKS1IyRkhhRTVXYmtKMlZtMTBVMU14VVhsVVdHeFZZVEZ3YUZWcVNtOVdSbEpZVGxjNVYxWnNjRWhYVkU1dllWVXhjbUpFVWxkTlYyaDJWMVphUzFKc1RuUlNiR1JwVjBkb05sWkdVa2RWTVZwMFVtdG9VRll5YUhCVmJHaERUbXhrVlZGdFJtcE5WMUl3VlRKMGExZEhTbGhoUjBaVlZucFdkbFl3V25KbFJtUnlXa1prVjJFelFqWldhMlI2VFZaWmQwMVdXbWxsYTFwWVdXeG9RMVJHVW5KWGJFcHNVbTFTZWxsVldsTmhWa3AxVVd4d1YySllVbGhhUkVaYVpVZEtTVk5zYUdoTk1VcFdWbGN4TkdReVZrZFdibEpPVmxkU1YxUlhkSGRXTVd4eVZXMUdXRkl3VmpSWk1HaExWMnhhV0ZWclpHRldWMUpRVlRCVk5WWXhjRWhoUjJoT1UwVktNbFp0TVRCVk1VMTRWVmhzVm1FeVVsVlpiWFIzWWpGV2NWTnRPVmRTYlhoYVdUQmFhMkpIU2toVmJHeGhWbGROTVZsV1ZYaFhSbFp5WVVaa1RtRnNXbFZXYTJRMFZERk9TRkpyWkZKaVJuQndWbXRXVm1ReFduUmpSV1JXVFZad01GVnRkRzlWUmxwMFlVWlNWVlpYYUVSVWJGcGhVMGRXU0ZKdGNFNVdNVWwzVmxSS01HRXhaRWhUYkdob1VqQmFWbFp1Y0Zka2JGbDNWMjVLYkZKdFVubFhhMXByVmpKRmVsRnFXbGRoTWxJMlZGWmFXbVZXVG5KYVIyaE9UVzFvV1ZkV1VrZGtNa1pIVjJ4V1UySkdjSE5WYlRGVFRWWlZlV042UmxoU2EzQmFWVmMxYjFZeFdYcGhTRXBWWVRKU1NGVnFSbUZYVm5CSVlVWk9WMVpHV2xkV2JHTjRUa2RSZVZaclpGZGliRXBQVm14a1UxWXhVbGhrU0dSWFRWZDRlVlpYTVVkWFJrbDNWbXBTV2sxSGFFeFdNbmhoVjBaV2NscEhSbGRXTVVwUlZsUkNWazVXV1hoalJXaG9VakpvVDFVd1ZrdE5iRnAwVFZSQ1ZrMVZNVFJXVm1oelZtMUZlVlZzVmxwaVdGSXpXV3BHVjJOV1RuUlBWbVJUWWxob1lWZFVRbUZoTWtwSVUydG9WbUpIZUdoV2JHUk9UVlpzVjFaWWFGaFNiRnA1V1ZWYWExUnRSbk5YYkZaWFlUSlJNRmxVUms5U01WcDFWR3hvYVZKc2NGbFhWM1J2VVRGT1YxZHJaRlpoTWxKWFZGWmFkMDFHVm5Sa1J6bFdVbXhzTlZsVmFFTldiVXBJWVVWU1ZXSllhSEpXYkZwSFpFWktkR05GTlZkTlZXd3pWbXhTUzAxSFJYaGFSV2hVWWtkb2IxVnFRbUZXYkZwMVkwWmthMkpHYkROV01qVkxZa1pLZEZWdWJGaGhNWEJ5Vm1wS1JtVnNSbkZYYkdSb1RXeEpNbFpHV21GWGJWRjNUVlprV0dKWGVITlpWRVozVjFaa1dHVkhPVkpOVlRFMFZsZDRhMWxXU2xkalNFNVdZbFJHVkZZeWVHdGpiRnBWVW14a1RsWnVRalpYVkVKaFZqRmtSMWRZY0ZaaWEzQllWbXRXWVdWc1duRlNiR1JxVFZkU2VsbFZaSE5XTVZwMVVXeEdWMkV4Y0doWFZtUlNaVlphY2xwR1pGaFNNMmg1VmxkMFYxTXhaRWRWYkdSWVltMVNjMVp0TVRCTk1WbDVUbGQwV0ZKcmJETldiWEJUVjJzeFNHRkZlRmROYm1ob1ZqQmFWMk5zY0VoU2JHUlhUVlZ3VWxac1pIZFRNVTE0VTFoc1UyRXlhRzlWYkZKWFYwWnNkR1JGZEU1aVJuQXdWRlpTUTFack1WWk5WRkpYVm5wV1ZGWnFTa1psVmxaMVVteGFhVkl4UlhkV2JURTBZekpOZUdORmFGQldiVkpVV1d0V2QxZHNXa2hsUjNCUFZteHNORll5TlU5aGJFcFlZVVpzVjJFeFZYaGFSM2h6VmpGYVdXRkdhRk5pUm05NFYxUkNZV0V4VW5OWFdHeG9Va1Z3V0ZSV1duZGhSbFkyVW10d2JGSnNTakZXYlhoTFlWWktjMk5HYkZkU2JFcElWWHBCTVdNeFpISmhSM2hUVFVad2FGWnRjRWRUTVVsNFZXNU9XR0pWV2xkVmJYaDNUVVphV0U1VlRsZE5hM0JKV1ZWV1UxWnJNVmRqUjJoYVRWWndVRmt4V2xkak1XUnlUbFprVGxaWGQzcFdiWGhUVXpBeFNGSllhR0ZTVjJoVldXdGtiMkl4Vm5GUmJVWlhZa1p3TVZrd1dtdGhNa3BIWWtST1YwMXFWa3haYTFwTFpFWldkV0pHYUdoTldFSjVWbTF3UzFKdFZuTlNia1pZWWtkU2IxUlhlRXBOYkZwSFYyMUdXR0pXV2xoV1J6VkxXVlpKZVdGRk9WVldla1oyVmpGYWExWXhWbkphUjNST1lURndTVlpxU2pSV01WVjVVMnRrYWxORk5WZFpiRkpIVmtaU1YxZHNXbXhXTURReVZXMTRiMVV5UlhwUmJVWlhWbTFOZUZscVJscGxSbVJaWTBkb1ZGSllRbGRYVmxKTFZURk9SMVp1UmxOaVZWcFpWbTAxUTFOV2JGWlhhemxYVFZad1NGWXllR3RXTWtwSVZHcFNWV0V5VWxOYVZscGhZMnh3UjFwSGJHbFNXRUpSVm0weE5HRXhWWGhYV0doV1lrZG9jbFV3WkZOWFJsSlhXa1JTYkZac2NGbFVWbFpyVjBaS2NtSkVUbGRpV0VKVVZqSnplRk5IUmtabFJtUk9ZbTFvYjFacVFtRldNazV6WTBWb1UySkhVbGhVVmxaM1ZXeGFjMVZyVGxkaGVsWllWakZvYjJGc1NsaGhSemxXWVd0d2RsWkVSbFprTVZweVpFVTFhVkp1UVhkV1JscFRVVEZhY2sxV1drNVdSa3BZVm0weGIyVnNXblJOVlZwc1ZteGFlbFp0ZUhkaFZtUkhVMWh3V0ZZelFraFdha3BQVmpGU2RWVnNRbGRpVmtwVlYxZDRiMkl4YkZkYVJsWlNZbFZhYjFSWGRIZFRWbFY1WkVjNVYySlZjRWxhVldSdlZqSktTRlZyT1ZWV2JIQjZWbXBHWVZkWFJrZGhSazVwVW01Qk1WWXhXbGRaVjBWNFZXNVNVMkpyTlZsWmExcGhWMFpzVlZOc1NrNVNiSEJHVlcxek5WVXdNVmRqUkVaWFlsaG9XRmxXV2t0a1ZrWjFWMnhvVjJKRmNFVlhhMUpDVFZkTmVGcElTbWhTTTFKVVZGVmFkMWRXWkZobFIwWmFWbTFTV0ZZeWVHOWhNVW8yWWtjNVZWWnNXak5VVlZwelZteGtjMVJzWkZkaVNFSmFWMVpXVjFVeFduSk5XRlpvVWpKb1lWcFhkR0ZOTVZaelYyeGthMUl3TlVkVWJGcHJWR3hhV0dRemNGZGlXR2hVVlhwQmVGTkdTbGxoUjBaVFZqSm9WbGRYZEd0aU1rbDRWbTVHVW1KVldsaFphMXAzVFZacmQxZHRkR2hOYTNCSVdXdFNUMVl3TVhGV2EzaGFZVEZ3VEZwRldsZGtWMHBJVW14T1YwMVZXWHBXYlhoVFV6RktkRlp1VGxOaWExcFpXV3RrVTJOR1ZuRlNhMXByVFZad2VWWlhkREJWTURGWFlrUlNWMUl6YUhwWlYzaExaRlpHY2s5V1ZsZGxhMW95Vm1wR1lXRXhXWGhXYmtwaFVqTlNUMWxVUm5kVFZscHhVMnBTVjAxV1ZqVlZNblJyWVd4T1JrNVdaRnBpUmtwSVZtdGFVMVl4WkhOWGJYaFhUVVJSZVZaWE1UUmlNVlY1VWxod1VtSlZXbGhXYlRGT1pVWnNjVkpzY0d4U2JWSmFXVEJrYjFaR1NsbFJiR1JZVm14S1RGWlVSazlTTVZwMVVteE9hVlpXY0ZwV2JUQXhVVEZPVjJKR1dsaGhlbXhZVkZaYWQxTkdXWGxsUjNSWFRXdHdTVlpIY0ZOV1YwVjVWV3hPWVZac2NHaFpNbmgzVWpGd1IyRkdUazVOYldjeFZtMTRhMlF4UlhoaVJtaFZZVEpTV0ZsdGVFdGpNVlYzV2taT2FrMVhlSGxXTWpWUFZERmFkVkZzWkZwV1YxRjNWakJhUzJOdFNrVlViR1JwVjBWS1ZWWnFTbnBsUmtsNFZHNU9VbUpIVWs5WlYzUmhVMFprYzFkdFJsZE5helY2V1RCV2IxVXlTa2hWYXpsVlZucEdkbFV5ZUZwbFJsWnlZMGQ0VTJGNlJUQldWRVp2WXpGVmVWSlliRlppVkd4WFdXeG9iMVJHV25KWGJVWnFUV3RhUjFaSGVGTlViRnAxVVZoa1YxSnNjRlJWVkVaaFkyc3hWMWRyTlZkU2EzQlpWMWQwYTJJeVVuTlhXR1JZWWxoU1ZWVnFRbUZUUm14eVYyNWthRlp0VWtsWlZXTTFWakpLV1ZGcmFGcGxhM0JQV2xWa1QxSnRSa2RSYkdScFZtdHdWbFl4WkRSaU1rbDRZa1prWVZKc1dsTlpiRlpoWWpGU1dHUklaRlJXYkZZMVdrVmpOVll5U2xaalJXeGhWbGRTZGxacVNrdFRSbFp5VDFaV1YySklRalpXYlhCSFdWWmtXRkpyWkdoU2F6VndWVzAxUWsxV1dYaFhiR1JhVmpCV05GWlhOVk5WTWtweVRsWnNXbUV4Y0doV01GcHpWbFpPYzFOck5WTmlXR2hYVmxjeGVrNVdWWGROVm1ScVVrVmFXRlZxVG05a2JHeFhWMnQwYWsxck5VaFphMXB2VmpBd2VGTnFTbGRXYkVwSVZrUkdXbVZHY0VsVGJVWlRZa2hDZGxaR1pEUlRNV1JIVjJ0a1dHSlZXbkpVVlZKSFUwWmFkRTVXVG1oTlZXOHlXV3RhYTFadFNsbGhTSEJWWWtad2VsWnRNVWRTYkZKeldrZHNWMWRGU2t0V01WcFhWakZWZUZkc2FGUmlSM2h2VlRCV2QxZEdiSEpYYm1SVVVtNUNSMVl5ZERCaE1VbDNUbFZrVldKR2NISldSM2hoVjBkUmVtTkdaR2xYUjJoVlZsaHdRbVZHVGtkVGJHeG9VakJhVkZacVNtOVdiR1JZWkVkMGFVMXJiRFJXYlRWSFZXMUtWbGRzYUZwaE1YQXpWRlphY21ReFpIUmtSMmhPWVROQ1NWZFhkRk5VTVZsM1RWaEdWMkV6YUdGWlZFWjNWRVp3Umxkc1pHdFdNSEJJV1ZWa2IxUnNaRVpUYWxaWFlsUkdNMVY2Umt0a1JscDFWR3hPYVdFeGNGcFhWM1JyVlRKSmVGVnNhR3hTV0VKUFdXdGFkMU5HV1hsTlZXUllVakJ3V0ZZeWVHOVdNVW8yVm10NFdGWnNjRXRhVm1SSFVtczVWMVpzWkd4aE1XOTVWbTF3UjFsWFJYaFhXR2hYWW10d2FGVnFUbE5VTVd4VlVtNWtWRlpzY0hoVk1uQlRWakF4VjFacVZsWk5ibEp5V1ZkNFQxSnJOVmRhUm5CcFVtdHdTVlp0ZEdGVk1WbDRXa2hPV0dKWWFGaFVWVkpTWlZaYVdFMVVVbWxOVmxZMVZXeG9kMVZ0U2xaWGJHaFhZbFJHVDFwVlduTmpWa3B6WTBkNFUySldTalJXYWtvMFV6SkdTRk5yV21wU01taFpWbTB4VW1ReFpGZFhiazVYVFdzMVNGWXllRzloVmtsNFUyNW9WMUp0VVhkWFZscEtaVVpXV1dGR2FHbFhSa3AyVmxkd1IxbFhWbk5YV0d4c1VsZFNXRlJYZEZkT1JtdDNXa2M1V0ZKc2NEQldWM2hQV1ZaYWMyTkhhRnBOYm1nelZXcEdkMUl5UmtkVWF6Vk9ZbGRqZUZadE1UUmhNREZIVjFob1ZWZEhhR2hWYkdSVFZqRnNjbHBHVGxoV2JYZ3dWRlphVDJGck1WZGpSRUpWVm14S1JGWkhjM2hXTWtwRlZteFdhVkl4UmpOV2FrSmhVekpPZEZOclZsVmlSMUp3VmpCV1MxWldXbkZUYm5Cc1VtdHNORlpITlU5VmJVcElWVzA1V2xaRk5VUlZNVnByVmxaT2NWVnRhRTVoZWxWM1ZtMHhNR0V4YkZkVGJGWlhZa2RvWVZsc2FGTlVSbFY1WlVad2JGSnNXbmxaTUdRMFZUSkdObEpVUWxkV1JWcDJXV3BLUjJNeFRuTmhSMmhVVWxWd1dGZFhlRk5TTWxKelYyNUtXR0pWV25GVVYzUmhVakZhU0dWR1RsVmlSbkF4VlZab2ExWXhTbk5qUmxKV1ZrVmFhRmt5YzNoV01XUjBZa1pPVTJKSVFsbFdNV1F3WVRKSmVWVnVUbGhYUjFKWldXeG9VMVpXVm5GU2JVWlVVbXhzTlZwVmFHdFdNREZXWTBab1dtRnJOVE5XTUZwaFl6RmtkR0ZHWkdoaE0wSlJWbTF3UjFVeVVsZFdiazVTWWtkU2NGWnRkSGRXYkZsNFdrUkNWMDFzUmpSWGEyaFBWMGRGZVdGSVRsWmhhelZFVmxWYVlXUkhWa2xVYXpsVFlrZDNNVlpIZUZaT1YwWklVMnRhYWxKdGVHRldiRnAzWld4YWNWTnJXbXhTYkhCYVdWVmtSMVV3TUhsaFJGcFhZbGhDU0ZkV1dtdFhSa3B5V2tkb1UyRjZWbmRXVnpCM1RsVTFSMWRZYUZaaE1EVmhWbXBDVjA1R1dsaE9WVGxZVW0xU1NWcFZZelZXYlVWNFYycE9WMDFHY0hwV01HUlRVbTFTU0dOSGJGTmlSM1ExVm14amQyVkZNVWRYV0dST1ZtMVNjVlZyVm1GV01WSllUbGM1VTFKc2NIaFZNblF3VmtaYWNsZHFSbGhoTVhCeVdWWmFhMUl4VG5OaVJtUnBWa1ZKTUZac1kzaFdNVWw0WTBWc1YySkZOWEJWYkdoRFpERmFkR1ZIUm10TmExcElWakkxVTFSc1RraGhSbVJWVm14VmVGWXdXbHBsVjFaSVQxZG9UbFpYT0hsWFYzUnFUbFphVjFkdVRsaGhhelZXVm14YWQyRkdXWGRhUlRsUFlrWndlbGRyVlRGaFJURlpVVlJHVjJKWVFreFVWVlV4VWpGa2RWTnJOVmhTYkhCMlZsUkNWMlF4WkVkaVJtaHJVakJhYjFWdE5VTlNNVmw1WkVSQ2FFMVZiRE5VYkZaclZsZEtSMk5JU2xkU00yaG9WakJrVW1WdFRrZGFSMnhZVWpKb1ZsWnNhSGRSYlZaSFZHdGtWR0pIZUc5VmFrSmhWa1phY1ZOdE9WZGlSMUpaV2tWa01HRlZNWEppUkZKWFlsUldTRlpYTVV0V2JHUnpZVVp3YUUxWVFYcFdSbHBoWTIxUmVGcElVbXRTTW1oUFdWUk9RMU5XWkZoa1JrNVZUVlpzTTFSV2FFZFdNa1Y2WVVkR1dsWkZXak5XUlZwM1VteGtjMXBIZEZkTlNFSkpWMVpXYTJJeFVuTmFSVnBVWVd4YVdGbHNVa2ROTVZZMlVtdDBhMUpzY0RGV1IzaFBZVmRGZUdOR2NGaFdNMUp5VmxSS1NtVkdWbk5oUjNoVFYwVktVRmRYZEdGa01VNUhWMWhzVGxaWFVsbFZha0ozVjBaWmVXVkhPVmROVlc4eVZtMTBORmRHV25OalJYUmhWbTFTU0ZWdGN6VldNVnB6V2tkNGFFMVhPVFZXYlRGM1VqRnNXRkpZYUZoWFIyaFlXVzEwZDJGR1ZuRlViRTVWVFZkNFZsVnROV3RXUmxwelkwaG9WazF1UWxSV2FrRjRWakZhY1Zac1drNWliRXA1VjFaa05GUXhTbkpPVm1SaFVtNUNjRlZ0ZEhkVFZscDBaRWRHVmsxV2JEUlhhMmhQVjBkS1dXRkdhRlZXVmtwVFdsWmFZVmRGTVZWVmJXeE9WbXhaTVZaWGVHOWtNVlowVTJ4YVdHSkhhRmhaYkZKSFZERndWbGR1VG1wV2EzQjZXVEJrTkZVeVNsZFRiVVpZVmtWS2NsbHFSbUZTTVU1ellrWkthVkl4U2xwV2JURTBVekZTUjFkc1ZsTmhlbXhVVkZaYWQwMVdWblJsUlRsb1ZteHdXRmt3V25kV01rcFZVVmhvVmxaRldsQldha3BMVWpGa2MyRkhhR3hpV0doYVZtdGFZVmxYVVhoVWEyUllWMGQ0YzFWcVFtRlhSbEpZWkVoa1ZGWnNjRWxaTUZwUFZqRlpkMVpxVmxkV00yaFFWMVphWVdNeVRraGhSbkJPWW0xbmVsWlhjRWRrTVU1SVUydGtWV0Y2VmxoV01GWkhUbFphZEUxVVVtaGhla1paVmxab2MxWldaRWhsUmxaWFRVZFNkbFpxUm5OamJIQkhWR3hvVjJKWVozZFdSbHBoVkRKR2NrMVdhR3hUUjNoWVZGZHdWMVZHV2tWU2JVWnJVakZLUmxaSGVHdGhWbHBHVm1wT1YySllRa05hVlZwTFZqRk9kVk5zYUdsU2JrSjNWbXBDVjFNeFRsZFhia1pVWVd4S1lWWnRNVk5UVmxaMFpFZEdhVkpyY0RCV1YzTTFWMjFLVlZKdVdscGhhMXBvV1RGYVIyUkdTbk5hUlRWb1pXeFpNbFl4VWtOV01rbDRWbGhzVkdFeWFGZFpXSEJ6Vm14YWRXTkZaR3RpUmxZMVdsVmFkMkpHU25OWGJteGFUVWRSTUZaVVNrZE9iRXBWVVd4a1YxSldjREpYVjNCTFVqSk5lRlJ1VG1oU2JIQndWbXBLYjFkR1pGaGtSMFpVVFZkU1NGWXlkRmRWTWtwSVZXNUdWVll6VW1oVmFrWmhVMGRXUjFSc1ZtbFNia0Y0VmxaYWIyRXhXWGhUYms1cVVteEtWMVpyVm1GaFJtdDVZek5vVjAxWFVubFViRnByVlRKRmVsRnNjRmROVjFGM1dWUktTbVZXVm5WVWJHaFlVakZLV2xkWGVHOVZNVnBYVm01R1VtSlZXbFZWYlRFMFZqRlplVTVYZEdoU2JIQXdWbGQwYzFkc1dsaFVWRVpYWVd0d1RGWXhXa2RqYlVaSFkwZDRhRTB3U2xGV01uaGhXVlpOZVZSdVRtRlRSVFZZV1d4a05GWkdVbGRXYm1SWFlrWnNORmRyVWxOaFZURnlZa1JTV21FeGNISlhWbHBMWXpGa2MxUnNjR2xTYkhCdlYxZHdSMVV4WkVoVmEyUmhVbFJXVDFadGRIZFhWbHB4VTFob1RsSXdXa2xWTW5SaFlXeEtXRlZzWkZWV00wSklWVEJhWVdNeFpIUlNiR1JPWVhwV1NsWlhNSGhTTVZWNFUyeGthbEpHY0ZoWmJHaERVMFprVjFkdGRGaFNhM0I1VjJ0a2IxVXlSalpXYm1SWFZucEJlRlZYYzNoV01XUlpZVVpvYVZJeFNtaFdiWEJEVmpBMVIxZHNhRTlXYXpWWFZGZDBkMlZXVW5OWGJrNVlZbFZXTkZrd1pHOVdNREZIWTBod1YySkdjRkJaZWtaUFkyczFWMVJ0YkZkaE0wSmhWbTB4ZDFNd01VWk5WV2hUWW10d1QxWnRNVk5XVm14WVpFZEdXRkpzV2pGWk1GWnJZVEpLUjJOR1dsWk5ibEYzVmxSQmVHTnJOVlpoUm5Cb1RWaENlVlpzVWt0VE1VcDBWR3RhVGxadGFGaFVWRUpMVTFaYWNsVnJaRmhpVmxwSVdUQldjMVpIU2xoaFJsSlZWa1Z3ZGxac1dtRlNNVnAwVW0xMFRtRXhjRWxXYWtreFZURlNjMVJyYUdoU2JWSldWbTE0WVdWc1VuSlhiVVpZVWxSV1YxUXhXbTlWTURGSlVXeG9WMkZyYnpCWlZFWmhaRVpPYzJKSGFGUlRSVXBYVjFkMFlXUXlWbk5YYmxKT1ZsZFNWRmxyV2t0bGJHUnlXa2hPVjAxWFVrZFZNblF3VmpBeFYyTkdhRmRoYTFwVFdsVmtTMUl4Y0VkVmJXaE9WMFZLWVZZeFpEUmhNa2w0WWtaa2FsSnRhSEpWYWtKaFZERlNWMWR0Um14aVJtdzFXbFZrTUdGRk1WWmlSRTVWWWtaYWNsWnNaRXRTTWs1SlUyeGtVMDB5YUc5V2FrSnJWVzFXZEZSclpHRlNNbmhaVldwS2IxWnNXbk5oU0dSU1lsWmFTRlpIZEd0V1YwcElaVWhDVm1KWVRYaFpha1pUVjBkV1JtUkdaR2xTTVVwYVZrWmFiMlF4VW5OWGJrNXFVbTFvWVZsVVNtOVVSbVJYVjJ0MFQySlZjRWhaVlZwM1lVVXhXVkZZY0ZoaVIxRXdWakl4VjFack5WZGhSM1JUWWtad2RsZHNaREJaVm1SWFdrWldVbUpVYkhGVVZscHpUVEZTVjJGRlpGWk5hMVkxV1ZWa1IxWXlSbkpPV0ZwYVZsWndlVnBXVlhoV2F6bFhWR3hrYUUwd1NUSldNVnBYWVRKSmVGVnVUbUZTVm5CVldXdFdkMWRHYkhOVmEyUk9UVlpaTWxWdGREQmhNVXB6WTBoc1dsWldjRmhaVlZWNFZqSk9SMkpHYUZkTk1VcDVWbXhTUjFsV1NYaFhibFpWWWtkb2NGbHNXa3RsYkZwMFRVaG9WazFYVW5wWlZFNXJWakpLV1ZWc2FGVldNMUl6VmpCYVYyUkhUa1pQVm1SWFlraENObFpxU1RGa01XUnpWMjVPYWxKWVVtaFdiVEZUVTBaV2NWSnNaR3BOYXpWSldXdGFUMVJ0U2xoYVJGWlhZbFJHTTFWcVJuTlhSa3BaWVVkR1UxWXlhRmxYVmxKTFlqRldWMWR1VW10VFIxSldWRlphZDAxR2NFWmhSM1JYVW14d2Vsa3dhSGRYUm1SSlVXdG9WMkV4VmpSV01GcFhZMjFLUjFkck5XbGlSWEIyVmpGYWEwNUdVWGhUYmtwUFZtMVNhRlZ0TlVOalJsWjBaRWhrVkZac2NEQmFSV1JIWVRBeFdGVnJiRmRpV0ZKNlZteGtTMU5HVm5WUmJGcG9ZVEZ3VFZaSE1UUlpWMDV6WVROd2FGSXllRTlXYlhoYVRVWmFjVk5xUWxwV2JWSkpWVzAxVDJGc1NuUmhSbWhhVmtWYWFGcFdXbmRXYkdSMVZHMXdWMkV6UWpaWFZFSnJUa1pWZVZOc1pGUmhiRXBZV1ZkMGRrMUdWalpTYlhSVFRWVTFXbGxyWkc5Vk1rcFlZVVpzV0ZZemFIWldWRVpyVWpGd1IxcEdhR2xoZWxaWlZrWmtlazFXVGtkWFdHeHNVbnBzYjFadE1WTlRSbFY1VGxoT1YwMXJjRlpWYkdocldWWktSbU5HYUZwbGExcHlXa1phVjJOck5WZGFSM2hwVjBkb1dWWnFSbXROUmxsNVZWaG9WV0V5VWxsV01HUTBWREZhYzFwR1RsaFNiRXBaV2tWb2ExWkdXbk5qUld4YVRVWndVRlpxUmxwa01WcHhWbXhrVjAweWFGRldNVnBoV1ZkTmVWUnJhR2hTYmtKUFdXMHhibVZzV2xoalJXUnJUVlUxU1ZVeWRHOWhWa3B5VGxac1ZtSkdXbmxhVlZwaFpFVXhWVlZzV2s1V1Zsa3hWbGQ0YjJJeFdYaGFSV2hzVW14d1lWWnJWbmRXUmxsM1YyNU9hMUl4U2tsVmJYaGhWR3haZWxvelpGZFNiSEJvVmtSR2ExSXhUblZVYkZKcFVqSm9XVlpHWkhkV01WWkhWMnRXVTJKVlduSldiWFJoWlZaa2NsZHVaRmROVm5CNlZteG9iMVl5Um5KVGJXaFdUV3BHVTFwV1dsTmpiR1IwWVVaT2FXRXdjRkZXYkdOM1RWWkZkMDFZVGxoaWExcFZXVzAxUTJNeFZuUmtTRTVQVW14d1NWUnNWVFZXYlVwV1kwVnNWMVl6VFRGV01uaGFaV3hXZEdGR1drNVNia0o1VjFod1IyRXlVa2RUYms1aFVsUldiMXBYZUZwTmJGbDRWV3RPVjAxcmJEUldiR2h6VmtkRmVXRkdaRnBYU0VKNlZtMTRZV1JYVGtaYVIzUnBVbXhaTVZkc1ZtRmtNa3BIVTI1T1dHSnRlR0ZVVldSU1RVWmFWVk5yWkU5aVJYQldWVmQ0YTFZeFNsZGpSRXBZVmpOQ1RGVnFTazVsUmxKMVZHMW9VMDF0YUZaV1YzaFhaREZrUjFwR2FHeFNhelZVVkZkNFMyVnNXWGxPVlhSWVVqQndWMVl5TlVkV1ZsbDZWVzFvVm1GcldtaFZNR1JYVWpGU2MxWnRiRk5pYTBZMFZteGFZV0l5UlhoWFdHaFVZbXMxY1ZWdGVFdFdNVnB5Vm0xR2FGSnRkRFZaZWs1dlZqQXhXRlZ1YkZWaVJuQnlWbFJLUm1Wc1JuTmpSbVJPVmpGR00xZFdVa3RUYlZaWFZtNVdWV0pIYUZsVmFrWkxWMnhrV0dWSE9WWk5WbkJZVm0wMVIxVnRTbFpYYkZaWFlsUkZNRlpxUmxwbFZURldXa1prVjAxSVFraFhWRUpUVWpGYWMxZHFXbEpXUlZwWVdWZDBkMVJHV25OWGEzUlhWbXRhZWxrd1pEUmhSVEIzVTJ4S1YwMVhhRE5WYWtwU1pVWlNjMXBHVm1saVJYQjVWbGN4ZWsxV1VYaFZiRnBYWW0xU1dGbHJXbk5PUm1SeVZXdE9hRlpVUmxkV2JYQlBWbGRLUjFkdVNsZE5SMUpNV1RJeFQxTkdTbk5XYkdSVFYwVktWbFp0ZUZkWlZteFlWV3RvVjJFeWVGWlpXSEJ6Vmtac2NscEVUazVXYkhCSldsVmFZVlF4V1hkWGEyeFdUVzVTYUZsWGVFdGtSMVpJVW14a2FWSnVRWHBYYkdRMFdWZE9WMVJ1U2xoaVdHaFVXV3RvUTFsV1pGZFdiWFJUVFZaV00xUlZhSE5oUmtwSFkwWm9XbUpIYUVSVk1GcHJWakZrZEdSR2FGTmhNMEkxVmpKMGEySXhWWGxTYWxwWFltMVNXRlp1Y0VOTk1WSnpWbFJHVTAxWFVscFpWVnBoWVVVeFJWWnRhRmRpV0VKRVZtcEJNVkl4WkhOaFJUbFhWa2Q0V2xaWE1IaFZNVTVYWTBaYVdtVnNXbGhaYkZaWFRrWlplV05GT1ZkTlJFWklXVEJvZDFZd01VaFZiRkpXWWxSR1ZGVXdaRTlUUjBwSFZHMXNVMDB4UlhoV2JURTBZVzFSZVZacldrNVdWMUpaVmpCa1UxUXhXblJOVms1cVZteGFlVlp0TVVkV01ERlhVMnhzVldKSFRURldWRVpMWXpKT1NXRkdXazVpYkVZelZtMTBZVmxYVG5OYVNFWlRZa2RvYjFSV2FFTmxWbVJYVjIxR2FFMVZiRFJXUnpWUFlWWktkRlZ1UWxkaE1WcExWRlZhWVdNeGEzcGhSbVJPVmxkM01GZFVRbGRqTVZsNVUydGFUMWRGU2xkWmEyUnZVa1p3UlZKdFJtdFNNVnBKVlcweE1GUnRSWGhqUld4WFlXdHJlRlpVUmxOak1XUnlWMnhTYVdFeGNGZFdiWGhoVXpGa1IxZFlaRmhpVlZweVZXeFNWMWRHV2toTlZ6bFZZa1p3V1ZRd2FITlhSbGw2Vlcxb1dsWkZXbWhhUlZwUFl6SktTR0ZHVWxSU1ZYQllWakZrTUZsWFVYbFdiazVZWW14S1QxWnNaRk5XUm14eVYydDBiR0pIVW5sWGEyaFBWakF4V0ZWclpGWk5ibEYzVm1wQmVGWXlUa2RoUm1Sb1lURndWRmRzVm10VE1VbDRZMFZrVm1KWGFFOVdNRlpMV1ZaWmVGa3phRTVTTVVZMFYydFdhMkZXU25SaFNFcFdZV3RLYUZscVJsZGtSVFZXVkd4T1RsWnVRalpXYkdRMFlURlpkMDFWVmxOaVIyaGhWRlZrYjJWc1duTmFSWFJUVFdzMVNsVXllSGRXTWtwWFUydG9XR0V4U2toWlZFWnJWMFpTY2xwSFJsTk5ibWhhVmxkd1MySXdOVWRYV0d4clVtczFVMWxzV21GVFJsbDRZVWM1VjJKVmNFbGFWV00xVm0xS1dXRkVUbGROVm5CWVdURmFUMlJGT1ZkaFIyeFRUVlZ3WVZacldtRmlNbEY0Vlc1T1dHSnJOWEZWYlRGdldWWnNWVk50T1ZWU2JWSllWakowTUZReVNsWmpSV2hhVmxad00xbFZWWGhYVmtaWlkwWm9hVkl4UlhkV2FrbDRWakZhY2s1V1pHaFNNMUpVV1d0YWQyUnNaSE5hUkVKYVZtMVNXRmRyV2xkVmJVcFZZa2hHVlZac2NIcFVWRVpUVmpKR1JscEdXazVoTVZreFYxWldhMUl4V1hsU2JrcFBWMFp3WVZac1duZGxWbkJYVmxob1YyRjZiRmhXUjNocllVVXhXRTlVVGxkaVIwNDBWR3RhVW1WR1pGbGFSVFZYWWtoQ1dsWnFRbTlSTVdSSFlraE9hRko2YkZoVmJYaGFUV3hXZEdSRVFtaE5WWEI2V1RCU1IxWXhTWHBoUmtKYVZteHdTMXBYTVVkVFJUbFhXa1prYkdFd2EzZFdNV1IzVXpGUmVGTllhRmhpYkZwWFdXeG9iMVpXVm5GU2EzUnJUVlp3U0ZZeU1UQldhekZZVld0b1YwMXVhSFpaVkVaTFVteE9jMXBHVmxkV2EzQkpWbXBDWVdNeVRuTldiazVWWWtkU1QxWnNZelJsVmxwMFRWUlNhVTFXYkRWVk1uUnZWbTFGZW1GR2FGVldWMUpVVlRCYVYyUkhUalpXYkdST1ZtNUNObFl5ZEd0T1IwWkdUVlpvVUZaR1dsaFpiRkpIVFRGV2NWSnVUbGhTYTNCYVdWVmFiMWRHU1hsaFJteFlWbnBGZDFwRVNrZFNNVnAxVW14V2FWSlVWbGRXUmxwclRrWmFjMVp1VWs5V00xSllWVzE0ZDJWc2EzZGhSemxYWVhwR01WVlhlRk5XTWtaeVVtcFNWMkZyV21oWk1WcGhZekZrY2s1WGJHbFNXRUV4Vm1wR1lXRXdOVWRWV0doVVltdHdVRlp0TVZOaFJsWjBUbFZPYWxKc1dqQmFSV2hyVmtaYWMyTkVRbUZTVjFKSVZtMXplRll5U2tWVmJHaG9UVzFvVVZacVFtdFRNV1JZVW10a2FGSnNXbGhXYlhSM1ZrWmtjMWR0UmxwV2JWSkhWRlphVjFadFNsaGhSVGxYWWxoU00xUnRlR0ZqVms1VlVteGtUbFpzYjNkV1Z6QXhWREpHYzFOdVVteFNiV2hoVm10V1lXRkdXa1pYYms1WFlrZFNNRlZ0TVhkV01rVjZVVmhrV0dFeFdtaFdSRVpUWXpGa1dXRkdVbGhTTW1oWlYxWlNTMVZyTVVkWGJGWlVZVEpTVkZsWWNFZFhiRnBZVFZjNVZrMXNXakJhVlZwelZqSktXVkZzUWxkV1JWcHlWV3BHZDFJeGNFaFNiRTVYVWpOb05GWnJXbUZaVjFGM1RWWmtWMkpzU25OVmJYTXhZakZXYzFWclRrOVNiRlkxV2xWa1IxWXdNWEpqUmxwV1lrWktSRlp0TVZkamJFcHhWV3hhYUdFelFrMVdWM0JIWVRKTmVWSnJhR2hTTTJod1ZqQmtiMWxXV25Sa1IwWmFWbTE0V1ZaV2FHOVdWMFY1Vld4c1YwMUhVVEJXUkVaaFl6RndSMVJzYUZOaVJYQmFWMnRXYjJFeFdrZFhiazVxVWxkNFlWUlZXbmRWUmxweFVteHdhMDFXY0hoV2JYaHJWakF3ZVdGR1JsZE5WbkJvVjFaa1RtVldVbkpoUjJoVFltdEtVRmRYTUhoaWJWWnpWMnhvYWxKWFVuSlVWbFV4VTFaVmVXUkhPV2hXYTNCNVZHeGFjMVp0U2tkWGJteGhWbFp3YUZwRlZYaFdWbFp6VjJzMVYxWnNhM2hXYkdRMFlqSkplRmRZYUdGU1YyaHpWVzE0ZDFsV1duSldibVJYVW14c00xWXlOVTloTVVsNFUydHNWbUpZYUdoV1IzaGFaV3h2ZWxwR1pGTmlTRUp2Vm10U1IyRXhTWGhVYmxaVllrWktjRlZxU205WFZscEhXa2hrVjAxV1draFdNblJYVlRKS1ZsZHVTbGRpV0ZKb1dsWmFhMk5zWkhWYVJtUk9WbTVDTmxadGVHOWlNVmw1VW01S1ZHSlhhRmRVVjNCSFZURndWMWRzVG1waVIxSXdXVlZhVDJGWFJYZGpSa1pYWWtkT00xUldXa1prTURGWlZHeG9hV0V4Y0ZaWFZ6QXhVVEpOZUZadVVtcGxhMXBWVm0xNFlVMUdjRVphUldSb1ZtdHdlVmt3VWtOV01WbDZWRlJHVjAxcVJreFdiRnBMWkZaa2MyTkhhR2hOV0VKMlZqRlNSMWxXU1hsVmEyUlVZbXMxYUZWc1VsZGlNWEJZWlVad1RtSkdiRFJXVjNSUFZqQXhjbUpFVWxkaVIyaDZWbXRrUm1WWFJrZGFSbkJvVFd4S01sWnRNVFJaVjFKSVZtdG9VMkY2Vms5V2JUVkRWMnhrYzFadGRGTk5hMXA1VkZaYWMxVnRSWHBSYkd4YVZrVmFNMVpyV21GVFIxWklVbXhrVjJFelFsZFdWbVEwWVRGWmVGTnNaR3BTUlhCWlZqQm9RMU5HV25STlZtUlhUVlUxZWxsclpITlZNREYwWVVaV1dHSkhUalJVYTFwclVqRndSMkZIZEZOTlJuQldWa1phYTFVeFRrZFhXR2hvVWpOU1dWVnFRbmRsVmxKellVVjBWMkpWV25sV01uUTBWbTFHY2xkcVRsWmlXR2hvVm14YVMyUkhSa2RhUjJoT1RVVlpNRlp0ZUdGWlYwbDVVbGhvV0ZkSGFGVlpiWE14WTFaV2RHVkZkRmROVm5CNVZtMHhSMkZHU25Sa1JGWmFaV3MxZGxacVFYaFhSbFoxWWtaV2FWSnVRbmxXYkZKTFVtMVdjMUp1VG1wU2JWSndWbXRXU21Wc1pITldiWFJVWWxaYVdGWXlOVmRXVjBwSVlVaENXbUV4V2pOV1ZWcGhaRWRXU0ZKdGRFNWhla1V3Vm1wSk1WVXlTa2RUV0dSWVltczFZVmxVUm5kTk1WSldWMjVrVjJKVldrbGFSV1J2VlRKS1NWRllaRmRpUjFGM1dXcEdZV05yTVZkaFIyaFRVbFJXV1ZaR1ZtRmtNa1pIWWtSYVUySllVbkpWYWtKaFUwWmtjbHBIT1doU1ZFSXpWVEo0WVZZeVNraFVhbEpoVm5wR1dGVnFSbXRYVjBwSFZHMW9UbUpGY0ZWV01XUXdZVEZWZUZWWWFGWmlSbkJZV1cweFUxZEdiSEpYYms1UFVtMVNlVlpYZEU5aFJscFZVbXhrVjJKWVFsQldiR1JMVWpGa2RWTnNaRTVTTVVwTlYxUkplRlF4VGtkVGJrNVhZa2RTVkZZd1ZrdFdiRnAwWlVaa1dsWnRlRmxXVjNSdlZqSkZlV1ZHV2xwWFNFSjZWbXRhYzJOc2NFVlVhelZYWWtoQ1NsZHNWbUZaVmxGNFYxaGtXR0V5ZUZkVVZ6VlRZVVpzV0dWRmRHdFNNVnBKVlcxNGEyRldTblZSV0hCWVlrZFJNRmRXWkU5V01WSjFVMnhvYVZkSGFGVlhWM1J2VVRGc1YxcEdaRmRpV0ZKVVZGWmFWMDB4VWxaaFNFNW9VbXR3U0Zrd1dtOVhiVXBJWVVWU1ZrMUdjSEpXYWtaclpFZFNSMkZHVG1oTk1Fa3hWakZhVjJFeVVYaFdXR1JPVjBaYWIxVnRNVFJYUm14WVpFVjBXRkpzV1RKVmJYTTFWVEF4V0ZWcVJsZFdla1V3VmxSQmQyVkdUbk5TYkdSWFRUQktSVlp0Y0VKTlZrbDRXa2hPYUZKVWJGaFdhMlEwVjJ4YVdFMUlhRlpOVlRWWVdUQmFZVmR0Vm5OWGJHaGFZa1phV0ZScldscGxWMDVHVDFaa1RsSkZXa2xYVkVKdlpERlpkMDFWYUZaaVJrcFhXV3hTUjFaR1ZYZGFSVGxVVWpCd1NGWkhNWE5WTURCNFVsaG9WMkpVUlRCWlZ6RlhVbXN4Vmxkck5WZFdNbWhWVjFjeE5GTXhXa2RpUm1oc1UwZFNXVlZ0TVRSbFZtUnlXWHBXV0ZKc2NEQmFWVnBoVm0xS1ZWWnVTbHBXVm5CTVdrVmtWMUl5UmtkYVJUVnBZa1ZaZWxZeFdtdGxiVlpJVkc1S1QxWnNjRzlWYlRWRFlqRlNWMkZGVGs1aVJuQXdXVEJXUzJFd01YTlhiR3hXWWxoU2RsWlZXbUZrUmxaellVZEdWMDB4U2t4V1JsWmhXVmROZUdFemNHaFNiVkpQVm14a00wMUdaRlZSYkdScVRWWnNOVlV5ZEdGVU1XUkdVMnhrV21FeVVuWlZhMXAzVWxaS2RGSnRkRk5OVm5CS1ZsY3dlRTFHVW5SVGEyUnFVbGQ0V0ZsWGRIWmtNV3hWVW01T1YwMVdTbmxaYTFwTFlVZFdkR1ZHYkZoV2JWRjNWMVprUjFJeVRrZGhSM2hUVFRGS2VGZFhlRmRaVmtsNFkwVmFZVko2YkZkVVYzUlhUbXhXV0dOR1pGZE5WV3cyV1ZWb1IxWlhTa2RqUjJoWFlXdGFjbHBHV2xOak1rWklZa2RzYUUxSVFsbFdha1pyVFVac1dGVlliRmRpYXpWWldXMTRTMVF4V25OYVJrNVhVbTE0ZVZZeWREQmlSMHBJVlc1c1dHRXlhRkJXYWtGNFYwWldjbHBHV2s1aWJFWXpWbTF3UW1WR1dYbFVhMlJvVW0xU2IxbFVSbmRXUm1SelZtMTBWRTFWYkRSWk1GWnJWbTFLV0dGRk9WZE5SbHBNVjFaYVdtVkdhM3BoUlRWVFRWVlpNRll5ZEZkaE1rWlhVMjVTYUZORmNGZFpWM1JMWVVac2NWSnNaR3RTVkZaWFZrZDRUMVJzV25WUmFscFhZa2RSTUZsVVJscGtNREZXVm14T2FWSXlhR2hXUmxacllqSldjMWR1VG1GU1dGSlVWRmR6TVZOc1ZYbGxTR1JYVFd0d1dGVXlkRzlYUjBWNFUydG9XbFpGV25KV01GcFRZMnh3U0ZKc1RrNWliV2hoVm14a2QxTXlTWGRPVldSWVYwZDRjbFZ0Y3pGVk1XeHpWMjFHVkZKc2JEUlpWV00xVmpKS1ZtTkZiR0ZXVjAweFZtMHhTMVpXU25WWGJIQm9ZVEZ3VlZacVFsWmxSbVJHVDFaa1lWSXllRlJVVmxaM1dWWlplV1JHWkdoTlJFWkpWVzE0WVZSc1pFWmpTRUpXWVRGd1RGWXdXbk5qTVZaeldrWmtVMkpJUWtwWGJGWnJVakZSZVZOc1dtcFNWMmhoVm14YWQwMHhiRlpXV0doWVZtdGFXbGt3V205aFZrbDRVbGhrVjJGcmJEUldha1poWTJzMVYxcEhhRk5OTVVwVlYxZDBZV1F5VW5OYVNFNWhVa1ZLWVZadE1UUlhSbGw1WlVkMFdsWnJjRWhWTWpWSFZsWmFkRlZVUWxkTlJuQmhXbFprVjFORk9WaGhSazVvVFRCS2FGWXhXbGRoTVVsNFdraE9XR0V4Y0ZsWlYzTXhWMVphZEdWSVpFNU5WbkF3V2xWa01HRXhTWGhUYTJ4YVRVZFNlbFpxUm1GU01XUnlZMFprVGxadVFsbFhWbEpMVTIxV1IxWnVWbFZpVlZwVVZtMDFRMVpzWkZoa1JtUnJUVmRTU0ZscmFFOWhSa3B5VGxoR1dtRXhjRXhhVmxwYVpWVTFWazlXYUZOaE0wSTJWbFJLZDFJeFdYaFhXSEJvVW14S1dGUlZXbmRWUmxaMFpVVTVhMUpVYkZoWGExcHJZa2RGZDJFelpGZE5WMUl6VlhwR1VtVkdUbGxoUm1ocFlrWndXRmRYZUc5aU1WcFhWbTVHVTJFelVuSlVWbHAzVTBaWmVVMVVRbGRoZWtaWlZsZDBiMVl3TVhWaFNGcGFWa1ZhVEZWdGVFOWpNWEJIVm14a1YyRXpRa3BXYlhCRFdWZE5lVlJ1VGxkaWF6VldXV3RrVTFReFduTmFSRTVPWWtkU1dGWnRNRFZoTURGWVZXNXdWMDFYYUROWlZWcExWMWRHU0dGR1dtbFhSMmQ2VmxSQ1lXTnRWbGhVYWxwWFlrZFNUMVp0TlVOT2JGbDVaRWQwVDFJd1drZFVWbHB2VlVaYVIxZHNhRnBpUmtwSVZGUkdWMk5XU25WVWJHUk9ZVE5DU1ZZeWRHRlZNV1JIVTFoc2FGTkhVbGhXYWs1VFlVWndSVkp0UmxOTmEzQktWa2N4UjFVeFNuSmpSbVJYVW14d2FGcEVTbGRTTVZwMVZXMTBVMUpWY0ZsV1Z6RTBaREpXYzJFelpHaFNlbXhZV1Zod1IxZEdWWGxrUnpsWFRWWndSMVZ0Y0ZOV01rWnlWMjFvV2sxV2NHaFpla1pyWTJzMVdHSkhiRk5YUlVsNVZtMXdSMWxYUlhkT1ZXUldWMGRvVlZsdGRIZFZSbHAwVFZaT2FGSnNXakJVYkZaUFlXeEtjMWRxUW1GU1YyaHlWbXRhWVdNeVRrVlJiVVpUVmpGS1NWWnFRbXRUTVZsNFdraE9hVkp0VW5CV01GcExUV3hrVjFWclpGUmlWbHA2VlcwMVYxVnRTa2RqU0VKWFlURndhRlZzV21Ga1IwNUdXa1p3VjJKV1NraFdSbHBoVmpGYWRGTnNhR3hTVkd4WVdXeG9iMWxXVWxkWGJVWllVakZhU1ZReFpEQlViRnB6WWpOa1YxWkZiekJYVmxwclUwWk9jbUZIYUZOaVYyaG9WMWQwWVZNeFRrZFhiRlpUWWtVMVdGbHJaRk5OVmxwSVkzcFdhRlpyY0ZwVlZtaHJWMGRGZUZkdGFGZFNSVnBVV1hwR2ExZFhSa2RWYkdoVFRXMW9XbFl4WkRCaE1WWnlUVlZrWVZKdFVtaFZiR1JUVmxaV2RHTjZSbXhXYlhoNVZqSjBNR0ZHV25KaVJGSldUVzVvZWxZd1dscGxiVVpIVld4YWFWZEZOREJXVjNCTFZERktjMWR1VGxaaVYzaFVWRlpXZDA1R1duSlhiVVpvVFZaV00xUldXbXRXTWtwelUyNU9WbUpHU25wWmFrWmhaRWRTU1ZSck9WTmlSbGt4VmtkNGFrNVdXWGROVmxwcVUwaENZVlJWWkc5VVJscHhVbTFHVTJKVk5VaFpWVnAzWWtkRmVsRnJNVmRXTTBKSVdWUktVMUl4VG5WVWJGcHBVbFJXV1ZaWE1UUmtiVlpYVjI1U1RsTkhVbk5WYkZKWFUxWmFWMkZJVGxkTmEzQkpWbGN3TlZaV1drWmpSbEpYVFZad2VscEZWWGhXTVZKellVWk9hVkpZUW1GV01uUlhZakpGZUZkclpGaGlhelZ4Vld4a05GbFdVbFpYYm1SV1VteHdlRlZ0ZUhkaE1ERlhZMGhvVjJKWWFISldha0YzWlZkR1IxSnNaRTVXYmtKdlZqRmFhMVJ0VmxkVmJrcG9VakpvVkZsdGRFdFZSbVJZVFVob2FXSldXbnBXTW5odllXeEtXRlZ1U2xWV2JGVjRWVEZhVm1WWFVraFBWMmhYWVROQ05WWkhlR0ZqTVZwMFUydGtXR0ZyTlZoV2ExWmhZVVp3UmxaWWFGUldia0pKV2xWYVQxWXhTbk5qUlhSWFlrZFJNRmxxU2twbFJtUlpZVWRHVTFZeWFIWldWM0JMWWpGWmVHSklTbUZTYXpWWVZXMTRkMlZHVm5ST1ZUbG9ZbFZ3U1ZaWGNFZFhSMFY0WTBoS1YxSXphR0ZhVnpGSFVqRndSMXBHWkZOV2VtZ3pWbTEwVTFNeFNYbFVia3BPVm0xU2FGVnFUa05XUmxaelZtNWthVTFXY0RCYVZXUkhWMGRLVjFKcVVscGhNbWhNVjFaYVMxZFdWbk5WYkZaWFRUQXhORlpYTVRSV01XUklWbXRrWVZKdFVrOVdiVFZEVGxaa1ZWRnRSbXBOVm13MVZUSjRjMVZ0UlhkT1YyaFhZa1p3TTFaRldtRmpWa3B5VDFkMFYySkZiM2RXVnpFMFZESkdXRkpZWkdwU1JUVllWRlprVDA1R1VsWlhhelZzVW14YWVsZHJXbTloVjBwR1kwWkNWMVpGU25KWmFrWmhWakZXYzFwSFJsTmhlbFphVmxjeE5HUXdNVWRWYms1WVlsaFNXVlZ0ZEhOTk1XdDNWbTVPVjAxV2J6SlZWbEpIVmpBeGRXRkhhRlppV0doeVdURmFVMk15VGtoaFIyaE9WMFZLTWxadE1YZFJNVnAwVm10a1dHSkhVbGhaYlhoTFlqRldjMVZzWkdsTldFSlpXbFZhYTFSck1WZGpSRUpWVmxkb2RsWkhlRXBrTVZweFZXeHdhRTFZUW5sV2JYUmhZVEZPU0ZacmFGQldiSEJ3V1cxMFMwNXNXblJOVkZKYVZqQTFlbFl5TlV0aE1VcHpWMnhTV21FeWFFUldNbmhyWXpGYWRHUkdUazVoTVhBMVZrWmFZV0l5UlhoVGEyUnFVakJhV0ZsclduZFdNVkpYVjIxR1YxWnJOWGxhUlZwdlZqQXhSMk5GYkZoV1JVcG9XVlJLUjFKck1WZGlSa3BvWVROQ1dsWnRjRTlSTVZKSFZtNUdWR0Y2Vm5OVmJYaExUVlphU0UxWE9WWk5SRVl3V1ZWYVlWWXhXWHBoUm1oaFVrVmFjbFZxUm5kU01rWklaVVpPYkdKWWFGaFdNV1EwV1Zac1YxUnJaRmhYUjNoeVZXMHhVMVl4VWxoa1NHUlhUVlpzTlZSc1ZtdFdNVnB6WTBSQ1YxWXphRlJYVmxwYVpXMUdTV0pIUmxOU1ZtOTZWbGQ0WVZZeVVraFNhMlJoVWpKb1QxUlZWbHBOUmxwMFpVZEdXbFl3YkRWVmJHaHZXVlpLV0dGR1ZscFdSWEJVVmpGYWMyUkhVa2xhUm1ST1ZqTm9XbGRyVm10U01rWkhVMjVTYTFKR1dtRmFWM014Wkd4YWNWRllhRmhTYkZwNFZWZDRkMkZGTVZsUmJFWlhZa1pLVEZWdE1WZGpNVXAxVld4Q1YySldTbEJXYlRBeFVURmFWMWRzYUdwU1dGSlhXV3hhWVZkR1dsaE9WbVJYVmpCd1NWbFZXbk5XYlVaeVYydDRXbUZyV21oV01HUlhVMFU1VjFkck5XaGxiRnBhVmpGa01HSXhVWGhYV0doWVlURndXVmxyV2t0V2JGcDBaVWhrVkZKc1NubFdNbmgzWWtaYVZWSnNXbFpXZWtaMlZsUktTMU5XUmxsYVJtUnBVakZHTTFkWWNFZGhNVTVIVTI1V1ZHRjZiRmhWYkZKWFYxWmtWMXBFUW10TlZUVklXVlJPYzJKR1NsVmlTRXBXWVd0S2FGVXdXbkprTVhCRlZXMW9VMVpGV21GV1ZtUjNWakZaZVZOc2JGSmhNVXBaVm0xNGQxWXhjRmRYYkU1clZteEtNRmt3V2s5V01ERjBZVVphVjAxWFVYZFdiWE40VjBaU2NscEdhR2xpUlhCNVZsUkNhMVV4WkVkaVNFcFlZbXMxVUZWdE1WTmxWbHBZWkVVNVdGSXdjRWhaYTFKVFZtMUtXVkZzUWxkaVIxSk1WV3BLVDFOV1RuTmFSVFZUVFZWd1RsWXhhSGRTTVZGNVZHNUtVRlp0VW1oVmFrcHZWREZhZEU1VlRsVmlSbkI0VlcweFIxZHNXblJsUm14WFZqTlNkbFpxU2tabFIwNUlZVVphYVZKcmNEWldiWFJoWXpKT2RGSnJXbFJpV0ZKUFZtcEdTMDVzV25STlNHaFRUV3RhUjFSV1dtdGhiRXAwWlVaa1ZWWjZWbFJaVlZwelYwZFdSbVJHYUZOTlZuQktWbGN4TkZZeFdYaFRiRlpYWVRGYVdWbHJXbmRoUmxweFVtdHdiRkpyTlhwV2JURnpWVEpGZUdOR2FGZGlXRkpVVlZkek1WVnNRbFZOUkRBOQ=="""

# Convert the decoded bytes to a string
for i in range(25):
 var = base64.b64decode(var)
# res = res_bytes.decode('utf-8')
print(var)
# b'B100dyPa$$w0rd'