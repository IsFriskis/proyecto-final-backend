using System;
using UnityEngine;

public class GunScript : MonoBehaviour
{
    [SerializeField] public float damage = 50f;
    [SerializeField] public float range = 500f;

    public ParticleSystem muzzleFlash;
    public GameObject impactEffect;

    public Camera fpsCam;


    // Update is called once per frame
    void Update()
    {
        checkIfFiring("Fire1");
        
    }

    private void checkIfFiring(String buttonPressed)
    {
        if (Input.GetButtonDown(buttonPressed))
        {
            Shoot();
        }
    }
    private void Shoot()
    {
        muzzleFlash.Play();
        RaycastHit hit;
        if (Physics.Raycast(fpsCam.transform.position, fpsCam.transform.forward, out hit, range))
        {

            EnemyScript target = hit.transform.GetComponent<EnemyScript>();

            if (target != null)
            {
                target.TakeDamage(damage);
            }

        }
        GameObject impactGO = Instantiate(impactEffect, hit.point, Quaternion.LookRotation(hit.normal));
        Destroy(impactGO, 1f);
    }
}
